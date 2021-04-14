import { JsonpClientBackend } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Client } from '../models/Client';

@Component({
  selector: 'createclientsmodal',
  templateUrl: './createclientsmodal.component.html',
  styleUrls: ['./createclientsmodal.component.css']
})
export class CreateclientsmodalComponent implements OnInit {

  @Input() display = 'none';

  @Output() closeModal = new EventEmitter<string>();

  @Output() saveClient = new EventEmitter<Client>();

  public client: Client;

  constructor() { 
    this.client=new Client();
  }

  ngOnInit(): void {
  }

  onCloseHandled(){
    this.closeModal.next();
  }

  onSubmit(event:any){
    console.log(event)
    if(this.client.bussinessId!==""&&this.client.email!==""&&this.client.phone!==""){
      this.closeModal.next();
      this.client.dataAdded=new Date(this.client.dataAdded);
      this.saveClient.next(this.client)
    }
    
  }


}
