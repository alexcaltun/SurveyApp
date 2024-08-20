import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { IOrder } from './order.model';
import { DataService } from '../order.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-worker-example',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './worker-example.component.html',
  styleUrl: './worker-example.component.css'
})
export class WorkerExampleComponent {
  infoMessage = 'Please scan an order ID';
  barcode: string = '';
  orderId: string = '';
  order: IOrder | null = null;
  isConfirmDisabled: boolean = true;
  errorState: boolean = false;
  finishedState: boolean = false;

  constructor(private orderService: DataService) {

  }

  onKeyDown(event: KeyboardEvent) {
    if (event.key === 'Enter') {
      this.orderId = this.barcode;
      this.barcode = '';
      this.orderService.getOrderByOrderId(this.orderId).subscribe(
        (o) => {
          this.order = o;
          if (this.order.state == 'NEW') {
            this.isConfirmDisabled = false;
            this.finishedState = false;
            this.infoMessage = 'Please confirm the order';
          } else if (this.order.state == 'FINISHED') {
            this.isConfirmDisabled = true;
            this.finishedState = true;
            this.infoMessage = 'Order already finished';
          }
          this.errorState = false;
        },
        (error) => {
          this.infoMessage = 'Invalid order ID';
          this.errorState = true;
        }
      );
    }
  }

  confirmOrder() {
    if (this.order?.id != null) {
      this.orderService.finishOrder(this.order.id).subscribe(
        () => {
          this.order = null;
          this.infoMessage = 'Please scan a new order ID';
          this.isConfirmDisabled = true;
        },
        error => {
          console.error('Error finishing order:', error);
        }
      );
    }
  }

  cancelOrder() {
    if (this.order?.id != null) {
      this.orderService.cancelOrder(this.order.id).subscribe(
        () => {
          this.order = null;
          this.infoMessage = 'Please scan a new order ID';
          this.isConfirmDisabled = true;
          this.finishedState = false;
        },
        error => {
          console.error('Error cancelling order:', error);
        }
      );
    }
  }

}

