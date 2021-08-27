# MySQL-SpringBoot-SuperMarket-BASICS

## @Author: Iorran G. Vieira.

Projeto pessoal iniciado em 08/2021.
Foco do projeto é ser o backend de um sistema de um supermercado, cujo as funções são:
 
 * Cadastro, alteração e exclusão de funcionários.
 * Cadastro, alteração e exclusão de produtos.
 * Geração de notas fiscais (de forma simulada).
 
 E etc.
 
 Estudo Java há aproximadamente 5 meses com foco em Springboot + MySQL + POO há aproximadamente 2 meses, não tenho noção de algumas tecnologias ainda, mas procuro fazer da forma mais limpa possível.
 
 Atualmente o projeto possui as seguintes funções: 
 
 * Cadastro de funcionários.
 * Exclusão de funcionários.
 * Alteração de funcionários.
 * Cadastro de produtos.
 * Exclusão de produtos.
 * Alteração de produtos.
 
 ### Como rodar o projeto localmente:
 
 Faça o clone: 
 ```
 git clone https://github.com/yIorran/MySQL-SpringBoot-SuperMarket-BASICS.git
 ```
 
 * Método get funcionários: 
 ```
 localhost:8081/funcionarios
 ```
 
 * Método put funcionários(atualizar): 
 ```
 localhost:8081/funcionarios/{matricula}
 ```
 
 * Método delete funcionários: 
 ```
 localhost:8081/funcionarios/{matricula}
 ```
 
 * Método adiciona funcionários: 
 ```
 localhost:8081/funcionarios
 ```
 
 * Método get produtos: 
 ```
 localhost:8081/produtos
 ```
 
  * Método adiciona produtos: 
 ```
 localhost:8081/produtos
 ```
 
 * Método put produtos(atualizar): 
 ```
 localhost:8081/produtos/attprod/{id}
 ```
 
 * Método delete produtos: 
 ```
 localhost:8081/produtos/{id}
 ```
 
 ## Método Login implementado
 
  * Método get LoginFuncionarios: 
 ```
 localhost:8081/login
 ```
 
 * Método adiciona LoginFuncionarios: 
 ```
 localhost:8081/login/save
 ```
 
 * Método atualiza LoginFuncionarios: 
 ```
 localhost:8081/login/{matricula}
 ```
 
  * Método delete LoginFuncionarios: 
 ```
 localhost:8081/login/{matricula}
 ```
 
 * Método login LoginFuncionarios(usar verbo POST informando matricula e senha no corpo JSON): 
 ```
 localhost:8081/login
 ```
 

 ### (Comunicação feita através do Postman via JSON)
 
 
