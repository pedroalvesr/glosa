import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PaginasComponent } from './paginas.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { GuiasConciliadasComponent } from './guias-conciliadas/guias-conciliadas.component';


const routes: Routes = [
  {
    path: '', component: PaginasComponent, children: [
      { path: 'guias-conciliadas', component: GuiasConciliadasComponent },
      { path: 'dashboard', component: DashboardComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PaginasRoutingModule { }
