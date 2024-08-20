// src/app/data-view/data-view.component.ts
import { Component, OnInit, OnDestroy } from '@angular/core';
import { DataService } from '../order.service';
import { Subscription } from 'rxjs';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-data-view',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './dataview.component.html',
  styleUrls: ['./dataview.component.css'],
})
export class DataViewComponent implements OnInit, OnDestroy {

  data: any[] = [];
  loading: boolean = true;
  order: any;
  private pollSubscription: Subscription = new Subscription;

  constructor(private orderService: DataService) { }

  ngOnInit(): void {
    this.loading = true;
    this.data = [];
    this.startPolling();
  }

  ngOnDestroy(): void {
    this.loading = true;
    this.data = [];
    this.stopPolling();
  }

  startPolling(): void {
    this.pollSubscription = this.orderService.pollData(5000).subscribe( // Poll every 5 seconds
      response => {
        this.data = response;
        if (this.data.length > 0) {
          this.order = this.data[0];
        }
        console.log("Read order: ", this.order);
        this.loading = false;
      },
      error => {
        console.error('Error loading data', error);
        this.loading = false;
      }
    );
  }

  stopPolling(): void {
    if (this.pollSubscription) {
      this.pollSubscription.unsubscribe();
    }
  }

  finishOrder(): void {
    console.log("qweqwe");
    console.log(this.order);
    if (this.order.id) {
      this.orderService.finishOrder(this.order.id).subscribe(() => {
      });
    }
  }
}
