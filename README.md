Projeto de Comunicação Segura com Criptografia RSA
Este repositório contém uma implementação básica de um cliente e servidor utilizando sockets Java e criptografia RSA. O objetivo é demonstrar como estabelecer uma comunicação segura entre um cliente e um servidor, garantindo a confidencialidade das mensagens através da criptografia.

grupo 
    RM 98660 - Leonardo Valentim de Souza
    RM 97714 - João Victor Leite Firmino
    RM 99618 - Gustavo dos Santos Correa
    RM 551201 - Lucas Cazzaro
    RM 99219 - Ronaldo Riyudi Noda


Funcionalidades
Geração de Chaves RSA:
O servidor gera um par de chaves (pública e privada) para criptografar e decifrar mensagens.
Troca de Chaves:
O cliente e o servidor trocam suas chaves públicas para permitir a criptografia mútua.
Criptografia de Mensagens:
As mensagens enviadas pelo cliente são criptografadas com a chave pública do servidor antes de serem transmitidas.
Decifragem de Mensagens:
O servidor decifra as mensagens recebidas usando sua chave privada e vice-versa.
Estrutura do Projeto
Client:
Classe responsável por iniciar o cliente, estabelecer a conexão com o servidor, enviar mensagens criptografadas e receber respostas.
Server:
Classe que representa o servidor, que aguarda conexões, recebe mensagens e responde ao cliente.
Conexao:
Classe auxiliar para facilitar a comunicação entre cliente e servidor.
CriptografiaClienteServidor:
Classe que contém métodos para gerar chaves e realizar a criptografia e decifragem de mensagens.
RSA_EC:
Exemplo adicional de implementação de criptografia RSA com números primos.
Como Usar
Compile o projeto usando um IDE de Java ou ferramentas de linha de comando.

Inicie o servidor (Server).

Em outra instância, inicie o cliente (Client).

Siga as instruções no terminal para enviar e receber mensagens.
