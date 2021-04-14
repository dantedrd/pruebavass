import { Component, OnInit } from '@angular/core';
import { Client } from '../models/Client';
import { ClientService } from './clients.service';
import { saveAs } from 'file-saver';

@Component({
  selector: 'app-clients',
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  display = 'none';
  public clients: Array<Client>;

  constructor(private clientService: ClientService) {
    this.clients = [];
  }

  ngOnInit(): void {
    this.getAllClients();
  }

  openModal() {
    this.display = 'block';
  }

  closeModal() {
    this.display = 'none';
  }

  getAllClients() {
    this
      .clientService
      .getClients()
      .subscribe(data => {
        this.clients.length = 0;
        this.clients = this.clients.concat(data);
      });
  }

  searchClient(sharedKey: string) {
    var client = new Client();
    client.sharedKey = sharedKey;
    this
      .clientService
      .searchClient(client)
      .subscribe(data => {
        this.clients.length = 0;
        this.clients = this.clients.concat(data);
      });
  }

  saveClient(client: Client) {
    this
      .clientService
      .saveClient(client)
      .subscribe(() => {
        this.getAllClients();
      });
  }

  downloadFile() {
    var clientsArray:Array<any>=this.clients;
    const replacer = (key:any, value:any) => value === null ? '' : value; // specify how you want to handle null values here
    const header = Object.keys(this.clients[0]);
    let csv = clientsArray.map(row => header.map((fieldName:any) => JSON.stringify(row[fieldName], replacer)).join(','));
    csv.unshift(header.join(','));
    let csvArray = csv.join('\r\n');
    var blob = new Blob([csvArray], {type: 'text/csv' })
    saveAs(blob, "reporte.csv");
}

}
