import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Routes, RouterModule } from 'npm/CarApplication-front/CarApplication/node_modules/@angular/router';
import { HttpClientModule } from '@angular/common/http'

const appRoutes: Routes = [ 
  {
      path: '',
      redirectTo: 'car',
      pathMatch: 'full'
  } 
];

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  
 }
