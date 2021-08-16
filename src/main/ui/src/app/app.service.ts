import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http: HttpClient) { }

  rootURL = '/api';

  getAllDevices() {
    return this.http.get(this.rootURL + '/devices');
  }

  getAllCountries() {
     return this.http.get(this.rootURL + '/countries');
  }

  getTesters(country: String [], device: String [] ) {
    const params = {
        "country": country,
        "device": device
    };
    let search = JSON.stringify(params);
	return this.http.post(this.rootURL + '/testers', search);
  }

}
