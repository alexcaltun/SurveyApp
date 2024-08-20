// src/app/app.module.ts
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { DataViewComponent } from './dataview/dataview.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    CommonModule,
    AppComponent,
    DataViewComponent,
    FormsModule
  ],
  providers: [],
  bootstrap: []
})
export class AppModule { }
