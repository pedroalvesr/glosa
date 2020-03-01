import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { PaginasRoutingModule } from './paginas-routing.module';
import { PaginasComponent } from './paginas.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GuiasConciliadasComponent } from './guias-conciliadas/guias-conciliadas.component';


@NgModule({
  declarations: [
    PaginasComponent, 
    DashboardComponent, 
    GuiasConciliadasComponent],
  imports: [
    CommonModule,
    PaginasRoutingModule,
    HttpClientModule,
  ]
})
export class PaginasModule { }
