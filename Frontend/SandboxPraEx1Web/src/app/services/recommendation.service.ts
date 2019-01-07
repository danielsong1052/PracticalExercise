import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import { Recommendation } from '../models/recommendation';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RecommendationService {
  
  constructor(
    private http: Http,
    private httpc: HttpClient
  ) { }

  noAuthHeader = { headers: new HttpHeaders({ 'NoAuth' : 'True' })};

  getRecommendationAll(id:number){
    let myHeaders = new Headers();
    myHeaders.append('Content-Type','application/json');
    return this.http.get(environment.baseUrl + '/recommendation/'+`${id}`, {headers:myHeaders}).map(res => res.json());
  }

  addRecommendation(recommendation){
    console.log("iRecommendation Recommendation : "+JSON.stringify(recommendation));
    return this.httpc.post(environment.baseUrl + '/addRecommendation', recommendation, this.noAuthHeader);
  }
}
