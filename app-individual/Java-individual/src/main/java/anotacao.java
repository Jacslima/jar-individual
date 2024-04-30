public class anotacao {
//    create database ProjetoIndividual;
//    use ProjetoIndividual;
//
//    create table Empresa (
//            cnpj char(14) primary key unique,
//    nome varchar(45),
//    telefone char(11));
//
//-- Inserir a empresa São Paulo Tech School
//    INSERT INTO Empresa (cnpj, nome, telefone) VALUES ('11244042000194', 'São Paulo Tech School', '1135894043');
//
//    create table Componentes (
//            idComponente int primary key auto_increment,
//            nomeComponente varchar(45),
//    quantidade int,
//    preco decimal(5,2),
//    fkEmpresa char(14),
//    foreign key (fkEmpresa) references Empresa(cnpj)
//            );
//
//    create table Sala (
//            idSala int primary key auto_increment,
//            nome varchar(45),
//    andar int,
//    fkEmpresa char(14),
//    foreign key (fkEmpresa) references Empresa(cnpj)
//            );
//
//-- Inserir a primeira sala (ADSA)
//    INSERT INTO Sala (nome, andar, fkEmpresa) VALUES ('ADSA', 3, '11244042000194');
//
//-- Inserir a segunda sala (CCO)
//    INSERT INTO Sala (nome, andar, fkEmpresa) VALUES ('CCO', 8, '11244042000194');
//
//    create table Funcionario (
//            idFunc int primary key auto_increment,
//            nome varchar(45),
//    email varchar(45),
//    senha varchar(45),
//    telefone char(11),
//    tipo varchar(45),
//    check (tipo in('Empresa','Gestor','Técnico')),
//    turno varchar(20),
//    check (turno in('manhã', 'tarde', 'noite')),
//    estado varchar(20),
//    check (estado in('ativo', 'inativo')),
//    fkEmpresa char(14),
//    foreign key (fkEmpresa) references Empresa(cnpj)
//            );
//
//    INSERT INTO Funcionario (email, senha, fkEmpresa) VALUES ('jacsonlimaa22@gmail.com', 12345, '11244042000194');
//
//    create table Maquina(
//            idMaquina int primary key auto_increment,
//            hostname varchar(45),
//    ip varchar(45),
//    imagem date,
//    fkSala int,
//    fkEmpresa char(14),
//    foreign key (fkSala) references Sala(idSala),
//    foreign key (fkEmpresa) references Empresa(cnpj));
//
//-- Máquinas da sala ADSA
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('ADSA1', '12341', '2024-05-26', 1, '11244042000194');
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('ADSA2', '12342', '2024-05-26', 1, '11244042000194');
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('ADSA3', '12343', '2024-05-26', 1, '11244042000194');
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('ADSA4', '12344', '2024-05-26', 1, '11244042000194');
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('ADSA5', '12345', '2024-05-26', 1, '11244042000194');
//
//-- Máquinas da sala CCO
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('CCO1', '12351', '2024-05-26', 2, '11244042000194');
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('CCO2', '12352', '2024-05-26', 2, '11244042000194');
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('CCO3', '12353', '2024-05-26', 2, '11244042000194');
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('CCO4', '12354', '2024-05-26', 2, '11244042000194');
//    INSERT INTO Maquina (hostname, ip, imagem, fkSala, fkEmpresa) VALUES ('CCO5', '12355', '2024-05-26', 2, '11244042000194');
//
//
//    create table Metricas(
//            idMetrica int primary key auto_increment,
//            CompCpu int,
//            CompDisco double,
//            CompRam double,
//            fkEmpresa char(14),
//    foreign key (fkEmpresa) references Empresa(cnpj));
//
//-- Inserir métricas para a empresa São Paulo Tech School
//    INSERT INTO Metricas (CompCpu, CompDisco, CompRam, fkEmpresa) VALUES (50, 50.5, 70.2, '11244042000194');
//
//
//
//-- CRIAR TABELAS PARA CADA HARDWARE, COM SUAS RESPECTIVAS INFORMAÇÕES!!!
//
//    create table HistoricoManutencao(
//            idHistorico int primary key auto_increment,
//            Dia date,
//            descricao varchar(45),
//    tipo varchar(45),
//    fkMaquina int,
//    fkSala int,
//    responsavel int,
//    foreign key (fkMaquina) references Maquina(idMaquina),
//    foreign key (fkSala) references Sala(idSala),
//    foreign key (responsavel) references Funcionario(idFunc));
//
//    create table LeituraSO(
//            idSO int primary key auto_increment,
//            nome varchar(45),
//    tempoAtividade long,
//    dataLeitura datetime default current_timestamp,
//    fkMaquina int,
//    foreign key (fkMaquina) references Maquina(idMaquina)
//            );
//
//    create table LeituraDisco(
//            idDisco int primary key auto_increment,
//            tamanho double,
//            leituras double,
//            bytesLeitura double,
//            escritas double,
//            bytesEscrita double,
//            tempoTransferencia long,
//            dataLeitura datetime default current_timestamp,
//            fkMaquina int,
//            foreign key (fkMaquina) references Maquina(idMaquina)
//            );
//
//
//    create table LeituraJanelas(
//            idJanela int primary key auto_increment,
//            identificador int,
//            pid int,
//            titulo varchar(300),
//    totalJanelas int,
//    dataLeitura datetime default current_timestamp,
//    fkMaquina int,
//    foreign key (fkMaquina) references Maquina(idMaquina)
//            );
//
//    create table LeituraCPU(
//            idCPU int primary key auto_increment,
//            nome varchar(100),
//    emUso double,
//    dataLeitura datetime default current_timestamp,
//    fkMaquina int,
//    foreign key (fkMaquina) references Maquina(idMaquina)
//            );
//
//    create table LeituraMemoriaRam(
//            idRam int primary key auto_increment,
//            emUso double,
//            disponivel double,
//            total double,
//            dataLeitura datetime default current_timestamp,
//            fkMaquina int,
//            foreign key (fkMaquina) references Maquina(idMaquina)
//            );
//
//    CREATE TABLE HistoricoConsumo (
//            idHistorico INT PRIMARY KEY AUTO_INCREMENT,
//            tipoRecurso VARCHAR(20),
//    valor DOUBLE,
//    dataHora DATETIME,
//    fkMaquina INT,
//    FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
//            );
//
//
//
//    CREATE TABLE historico_consumo_cpu (
//            idHistoricoCPU INT PRIMARY KEY AUTO_INCREMENT,
//            consumoCpu DOUBLE,
//            dataHora DATETIME,
//            fkMaquina INT,
//            FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
//            );
//
//    CREATE TABLE historico_consumo_ram (
//            idHistoricoRam INT PRIMARY KEY AUTO_INCREMENT,
//            consumoRam DOUBLE,
//            dataHora DATETIME,
//            fkMaquina INT,
//            FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
//            );
//
//    CREATE TABLE historico_janelas (
//            idHistoricoJanelas INT PRIMARY KEY AUTO_INCREMENT,
//            totalJanelas INT,
//            dataHora DATETIME,
//            fkMaquina INT,
//            FOREIGN KEY (fkMaquina) REFERENCES Maquina(idMaquina)
//            );
//
//
//    CREATE TABLE hardwares (
//            id INT PRIMARY KEY AUTO_INCREMENT,
//            sistemaOperacional VARCHAR(100),
//    totalCpu DOUBLE,
//    totalDisco DOUBLE,
//    totalRam DOUBLE
//);
//
//
//    select * from Maquina;
//    select * from leituraSO;
//    select * from leituraDisco;
//    select * from leituraMemoriaRam;
//    select * from leituraJanelas;
//    select * from leituraCPU;
//    select * from Funcionario;
}
