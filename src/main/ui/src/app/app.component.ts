import {  OnDestroy } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AppService } from './app.service';
import { takeUntil } from 'rxjs/operators';
import { Subject } from 'rxjs';
import { NgSelectModule, NgOption } from '@ng-select/ng-select';
import { Component, NgModule, ViewChild } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {
  ReactiveFormsModule,
  FormsModule
} from '@angular/forms';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnDestroy {
  title = 'Find testers application';

  countries: any[] = [];
  devices: any[] = [];
  public results : any;

  inputDevices: any;
  inputCountries: any;

  constructor(private appService: AppService) {
      this.getAllDevices();
      this.getAllCountries();
  }


  destroy$: Subject<boolean> = new Subject<boolean>();

  onSubmit() {
    this.appService.getTesters(this.inputCountries, this.inputDevices).pipe(takeUntil(this.destroy$)).subscribe(data => {
      this.results = data;
    });
  }



  getAllCountries() {
    this.appService.getAllCountries().pipe(takeUntil(this.destroy$)).subscribe((country: any[]) => {
          const c = [];
          for(var x = 0; x < country.length; x ++){
            c.push(country[x]);
          }
          c.push("All");
          this.countries = c;
     });

  }



    getAllDevices() {
      this.appService.getAllDevices().pipe(takeUntil(this.destroy$)).subscribe((devs: any) => {
          const d = [];
          for (const device in devs ) {
            d.push(devs[device]);
          }
          d.push("All");
          this.devices = d;
      });
    }

  ngOnDestroy() {
    this.destroy$.next(true);
    this.destroy$.unsubscribe();
  }

  ngOnInit() {}
}
