import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Suporte } from 'src/app/models/suporte';

@Component({
  selector: 'app-lista-suporte',
  templateUrl: './lista-suporte.component.html',
  styleUrls: ['./lista-suporte.component.css']
})
export class ListaSuporteComponent implements OnInit {

  ELEMENT_DATA: Suporte[] = [
    {
      id: 1,
      nome: 'Hydrogen',
      cpf: '059.437.520-72',
      email: 'eduardo@gmail.com',
      telefone: '(11) 99999-9999',
      senha: '123456',
      perfis: ['GERENTE'],
      dataCriacao: '2020-10-10'
    }
  ]

  constructor() { }

  ngOnInit(): void {
  }
  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol', 'tel', 'acoes'];
  dataSource = new MatTableDataSource<Suporte>(this.ELEMENT_DATA);

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

}

