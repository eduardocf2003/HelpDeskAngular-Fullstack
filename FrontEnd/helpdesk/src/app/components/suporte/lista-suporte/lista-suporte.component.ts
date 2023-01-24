import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Suporte } from 'src/app/models/suporte';
import { SuporteService } from 'src/app/services/suporte.service';

@Component({
  selector: 'app-lista-suporte',
  templateUrl: './lista-suporte.component.html',
  styleUrls: ['./lista-suporte.component.css']
})
export class ListaSuporteComponent implements OnInit {

  ELEMENT_DATA: Suporte[] = []

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol', 'tel', 'acoes'];
  dataSource = new MatTableDataSource<Suporte>(this.ELEMENT_DATA);
  
  @ViewChild(MatPaginator) paginator: MatPaginator;

  
  constructor(
    private service: SuporteService
  ) { }

  ngOnInit(): void {
    this.findAll();
  }
  
  findAll() {
    this.service.findAll().subscribe(resposta => {
      this.ELEMENT_DATA = resposta;
      this.dataSource = new MatTableDataSource<Suporte>(resposta);
      this.dataSource.paginator = this.paginator;
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}

