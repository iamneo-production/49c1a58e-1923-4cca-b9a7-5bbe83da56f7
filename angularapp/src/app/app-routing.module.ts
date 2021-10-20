import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { UserOrderComponent } from './user-order/user-order.component';

const routes: Routes = [{path: '', component: HomeComponent},
{path: 'cart', component: CartComponent},
{path: 'orders', component: UserOrderComponent},];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
