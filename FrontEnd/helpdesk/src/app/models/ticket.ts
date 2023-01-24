import { Cliente } from "./cliente";
import { Suporte } from "./suporte";

export interface Ticket {
    id?: any;
    prioridade: string;
    status: string;
    titulo: string;
    dataAbertura?: any;
    dataFechamento?: any;
    descricao: string;
    suporte: any;
    cliente: any;
    nomeCliente: string;
    nomeTecnico: string;

}