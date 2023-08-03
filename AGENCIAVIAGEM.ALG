Algoritmo "agenciaviagem"
//
//
// Descrição   : Bem vindo(a) a agência de viagem!
// Autor(a)    : Fernanda Rodrigues
// Data atual  : 01/08/2023
Var

   cadastroCliente, cadastroDestino, emailCliente: vetor [1..3] de caractere
   valorDestino: real
   i , opcao, clientes, destinos: inteiro


Inicio

   clientes <- 0
   destinos <- 0

   escreval("=====================================")
   escreval("======= BEM VINDO A TRAVELAND =======")
   escreval("=====================================")

   repita
      escreval("Digite 1 para cadastrar o cliente")
      escreval("Digite 2 para cadastrar o destino")
      escreval("Digite 3 para consultar o cliente")
      escreval("Digite 4 para consultar o destino")
      escreval("Digite 5 para sair")
      leia(opcao)

      escolha(opcao)
      caso 1
         se clientes < 3 entao
            escreval("Qual o seu nome completo? ")
            leia(cadastroCliente[clientes+1])
            escreval("E-mail do cliente: ")
            leia(emailCliente[clientes+1])

            clientes <- clientes + 1
            escreval("Cadastrado com sucesso!")
         senao
            escreval("Limite máximo de clientes atingido. Cadastro não realizado.")
         fimse

         limpatela
      caso 2
         se destinos < 3 entao
            escreval("Informe o destino do cliente: ")
            leia(cadastroDestino[destinos+1])

            destinos <- destinos + 1
            escreval("Destino cadastrado com sucesso! ")
         senao
            escreval("Limite máximo de destinos atingido. Cadastro não realizado.")
         fimse
         limpatela
      caso 3
         se clientes = 0 entao
            escreval("Não há cliente cadastrado")
         senao
            para i de 1 ate clientes faca
               escreval ("Nome do cliente: " , cadastroCliente[i])
               escreval ("E-mail do cliente: " , emailCliente[i])
            fimpara
         fimse

      caso 4
         se destinos = 0 entao
            escreval("Não há destino cadastrado")
         senao
            para i de 1 ate destinos faca
               escreval ("Destino cadastrado foi: " , cadastroDestino[i])
            fimpara
         fimse
      caso 5
         escreval("===============================================")
         escreval("======= OBRIGADA POR ESCOLHER TRAVELAND =======")
         escreval("===============================================")
         interrompa
      outrocaso
         escreval("Opção inválida")
      fimEscolha

   ate opcao = 5


Fimalgoritmo