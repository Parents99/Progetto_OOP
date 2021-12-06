# FINDWORK - Lavoro Javascript, America, Role  
<h4>Repository creata per l'appello di dicembre 2021.</h4>

# Applicazione

<p>
Lo scopo dell'applicazione permette all'utente di trovare offerte di lavori riguardanti il linguaggio Javascript.              
Inoltre, il sistema dovrà generare delle statistiche dai risultati ottenuti.                     
I risultati delle ricerche e le statistiche potranno essere filtrati tramite filtri opportuni.              
Per facilitare l'utente, l'applicazione suggerisce il nome di 5 città americane su cui fare le ricerche.  

</p>

# Rotte Applicazione

<p>
Per le chiamate di tipo <b>Post</b> i parametri vengono passati attraverso un <b>Request Body</b>.                       
I parametri che dovranno essere passati sono:
<ul>
  <li>"location": (rappresenta il nome della città dove viene offerto il lavoro)</li>

<li>"remote": (indica se il lavoro è da remoto o no, quindi assume due valori -> true o false)</li>

  <li>"employment_type": (rappresenta il tipo di contratto: part-time o full-time o a contratto)</li>

  <li>"role": (indica la mansione del lavoro  es. Software Engineers)</li>
</ul>

<h3>1.</h3>
<table>
  <tr><td>Tipo</td><td>Path</td></tr>
  <tr><td>GET</td><td>localhost:8080/annunci</td></tr>
</table>

Fornisce all'utente tutti gli annunci di lavoro riguardanti il linguaggio Javascript.

<br><b>Esempio: </b> di seguito vengono riportati alcuni di tutti gli annunci generati</br>


<b>-Chiamata : localhost:8080/annunci </b>                   

![getAnnunci](https://user-images.githubusercontent.com/67264863/144684584-120734f6-8c60-4798-a9a6-a7b30f4a2366.png)

<b>-Risposta :</b>

![a4](https://user-images.githubusercontent.com/67264863/144684596-746a003e-99e8-4f43-8caf-c9bec6571192.png)
![a1](https://user-images.githubusercontent.com/67264863/144684597-ad22b6f2-6512-4e15-b148-99894a199f43.png)
![a3](https://user-images.githubusercontent.com/67264863/144684600-156cbca0-a4f0-4a10-8606-0a149b49c80e.png)

<h3>2.</h3>
<table>
  <tr><td>Tipo</td><td>Path</td></tr>
  <tr><td>GET</td><td>localhost:8080/tips</td></tr>
</table>

Fornisce all'utente ii nome di cinque città americane su cui poter fare successivamente le ricerche.

<br><b>Esempio: </b></br>


<b>-Chiamata : localhost:8080/tips </b>    

![getTips](https://user-images.githubusercontent.com/67264863/144685218-82205472-8130-4134-b53b-db166d3dbc31.png)

<b>-Risposta :</b>

![t1](https://user-images.githubusercontent.com/67264863/144685206-e7b5a841-18cd-4c72-bfaa-1956392f8f35.png)

<h3>3.</h3>
<table>
  <tr><td>Tipo</td><td>Path</td></tr>
  <tr><td>POST</td><td>localhost:8080/filters</td></tr>
</table>

Fornisce all'utente gli annunci di lavoro filtrati per i vari parametri dall'utente.
<br>I parametri da inserire nel <b>Body</b> sono: "luogo", "remoto", "orario" e "ruolo".
<br>E' possibile inserire anche solo un parametro per filtrare gli annunci.
<br>Inoltre è possibile inserire più città per richiesta nel parametro luogo.</br>

<br><b>Esempio: </b></br>

<b>-Chiamata : localhost:8080/filters </b>

![getFilt](https://user-images.githubusercontent.com/67264863/144686568-00985ea3-bd53-4dd2-be9c-75ef45eefc29.png)

<b>-Body : <br>{ 
 <br>           "luogo" : "Plano", 
 <br>           "remote" : false, 
  <br>          "orario" : "full time"
  <br>     } </br>
</b>

![bodyfilter](https://user-images.githubusercontent.com/67264863/144912481-d0a11d62-3f7e-45d4-b07f-fd2ae7f1e915.png)

In questo caso vengono restituiti all'utente solamente gli annunci in cui :
<br>
- il luogo è Plano; 
- remoto = false;
- orario è full time;
- mentre per quanto riguarda il ruolo, non essendo stato specificato, vengono mostrati gli annunci con qualsiasi ruolo. </br>

<b>-Risposta :</b>

![f2](https://user-images.githubusercontent.com/67264863/144686065-be956894-0647-4ee4-85f7-c0f79b751cc3.png)
![f3](https://user-images.githubusercontent.com/67264863/144686067-b9c5c992-b66b-4671-84b6-164dbb420111.png)

<h3>4.</h3>
<table>
  <tr><td>Tipo</td><td>Path</td></tr>
  <tr><td>POST</td><td>localhost:8080/statistics</td></tr>
</table>

Fornisce all'utente le statistiche sugli annunci.

<br><b>Esempio: </b></br>

<b>-Chiamata : localhost:8080/statistics </b>

![getStat](https://user-images.githubusercontent.com/67264863/144911010-a7dc75e2-e72c-474b-a126-2614152c7f31.png)

<b>-Body :</b>


<b>-Risposta :</b>

</p>

# UML

<ul><li>CASO D'USO</li></ul>

![2casoduso](https://user-images.githubusercontent.com/67264863/144909432-6fa5ea00-088a-4f09-8097-2002ceeee190.png)


<ul><li>CLASSI</li></ul>

![main](https://user-images.githubusercontent.com/67264863/144682982-731ac431-a9be-4a72-a16d-db4be3a65c5c.png)
![classeController](https://user-images.githubusercontent.com/67264863/144909603-b51665a9-4fac-4889-8af3-3563ba85c270.png)
![filter](https://user-images.githubusercontent.com/67264863/144683009-61b7558c-4da7-4aa4-934a-95c95f2123a8.png)
![statistic](https://user-images.githubusercontent.com/67264863/144683016-f38e23c2-704e-4349-aa55-0e4a4fa218ce.png)
![classeModel](https://user-images.githubusercontent.com/67264863/144909660-1e43ca2f-ece0-4a37-88d0-31ce8a05ac17.png)
![service](https://user-images.githubusercontent.com/67264863/144683099-01c0afb1-78fc-4b23-a0b9-02350a315e3f.png)
![database](https://user-images.githubusercontent.com/67264863/144683106-4dc470a7-420c-41bf-88b7-7cd760e2e7bd.png)

<ul><li>SEQUENZE</li></ul>

![sequenzaLavoro](https://user-images.githubusercontent.com/67264863/144681853-25756916-e45a-4d4f-8636-b57ec1e83a2f.png)

![sequenzaFiltro](https://user-images.githubusercontent.com/67264863/144681845-2d8348de-cad4-4087-a513-778614c42010.png)

![sequenzaStatistics](https://user-images.githubusercontent.com/67264863/144681858-76b0bf77-8bdd-4b3f-adf6-c6fb2cdc93d8.png)

![sequenzaCitta2](https://user-images.githubusercontent.com/67264863/144910113-61fcc309-e700-427b-a0a8-815d9426ba37.png)

# Autori

<table>
<tr><td>Nome e Cognome</td><td>Contributo</td><td>Email</td></tr>
<tr><td>Fiore Garzarella</td><td>50%</td><td><a href="S1089186@studenti.univpm.it">S1089186@studenti.univpm.it</a></td></tr>
<tr><td>Christian Parente</td><td>50%</td><td><a href="S1089031@studenti.univpm.it">S1089031@studenti.univpm.it</a></td></tr>
</table>

