/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Artur Pereira Neto &lt; artur.neto@ifnmg.edu.br &gt;
 * Created: 2 de jun de 2023
 */
 
/*
*   NOME DO BANCO DE DADOS: projpoo001
*/

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` bigint(20) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `lixo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
)


CREATE TABLE `contrato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `redacao` varchar(1000) NOT NULL,
  `ultimaAtualizacao` datetime NOT NULL,
  `idCliente` bigint(20) NOT NULL,
  `lixo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`)
)


