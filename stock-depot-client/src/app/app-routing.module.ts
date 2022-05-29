import { RouterModule, Routes } from "@angular/router";
import { AppComponent } from "./app.component";
import { NgModule } from "@angular/core";
import { DepotOwnerComponent } from "./depot-owner/depot-owner.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { DepotComponent } from "./depot/depot.component";

const routes: Routes = [
  { path: '', component: DepotOwnerComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'depot', component: DepotComponent}
];

export const routing = RouterModule.forRoot(routes);

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
