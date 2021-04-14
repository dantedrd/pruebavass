import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";
import { Client } from '../models/Client';

@Injectable({
  providedIn: 'root',
})
export class ClientService {
    private clientUrl = "http://localhost:8080/api/clients";
    constructor(private http: HttpClient) {}

  public getClients():Observable<Client> {
    return this.http.get<Client>(this.clientUrl);
  }

  public saveClient(client:Client):Observable<Client> {
    return this.http.post<Client>(this.clientUrl,{
      "sharedKey":client.email.split("@")[0].trim(),
      "bussinessId":client.bussinessId,
      "email":client.email,
      "phone":client.phone,
      "startDate":client.startDate,
      "endDate":client.endDate,
      "dataAdded":client.dataAdded.getTime()
    });
  }

  public searchClient(client:Client):Observable<Client> {
    let params = new HttpParams().set('sharedKey',client.sharedKey);  
    return this.http.get<Client>(this.clientUrl+"/search",{ params: params });
  }

}