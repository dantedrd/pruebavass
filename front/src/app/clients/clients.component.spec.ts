import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Observable } from 'rxjs';
import { Client } from '../models/Client';

import { ClientsComponent } from './clients.component';
import { ClientService } from './clients.service';


describe('ClientsComponent', () => {
  let component: ClientsComponent;
  let fixture: ComponentFixture<ClientsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientsComponent ],
      providers: [{
        provide: ClientService,
        useClass: ClientServiceMock
    }]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});


class ClientServiceMock{

  /**
   * This method is implemented in the AuthService
   * we extend, but we overload it to make sure we
   * return a value we wish to test against
   */
  getClients() {
      return new Observable(subcriber=>{
        subcriber.next([new Client()])
      })
  }
}