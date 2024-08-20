// src/app/data.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, timer } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { IOrder } from './worker-example/order.model';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private apiUrl = '/api/orders';

  constructor(private http: HttpClient) {

  }

  getData(): Observable<any> {
    return this.http.get<any>(this.apiUrl + '/NEW');
  }

  pollData(interval: number): Observable<any> {
    return timer(0, interval).pipe(
      switchMap(() => this.getData())
    );
  }

  finishOrder(id: number): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/${id}/finish`, {});
  }

  cancelOrder(id: number): Observable<void> {
    return this.http.post<void>(`${this.apiUrl}/${id}/cancel`, {});
  }

  getOrderByOrderId(orderId: string): Observable<IOrder> {
    return this.http.get<IOrder>(`${this.apiUrl}/id/${orderId}`, {});
  }
}
