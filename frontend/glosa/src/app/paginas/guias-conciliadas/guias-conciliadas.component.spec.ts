import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GuiasConciliadasComponent } from './guias-conciliadas.component';

describe('GuiasConciliadasComponent', () => {
  let component: GuiasConciliadasComponent;
  let fixture: ComponentFixture<GuiasConciliadasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GuiasConciliadasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GuiasConciliadasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
