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


<b>-Chiamata :</b>                   

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


<b>-Chiamata :</b>    

![getTips](https://user-images.githubusercontent.com/67264863/144685218-82205472-8130-4134-b53b-db166d3dbc31.png)

<b>-Risposta :</b>

![t1](https://user-images.githubusercontent.com/67264863/144685206-e7b5a841-18cd-4c72-bfaa-1956392f8f35.png)

<h3>3.</h3>
<table>
  <tr><td>Tipo</td><td>Path</td></tr>
  <tr><td>POST</td><td>localhost:8080/filters</td></tr>
</table>

Fornisce all'utente gli annunci di lavoro filtrati per i vari parametri dall'utente.
<br>I parametri da inserire nel <b>Body</b> sono: "luogo", "remoto", "orario" e "ruolo".</br>
<br>E' possibile inserire anche solo un parametro per filtrare gli annunci.</br>
<br>Inoltre è possibile inserire più città per richiesta nel parametro luogo.</br>

<br><b>Esempio: </b></br>

<b>-Chiamata :</b>

![getFilt](https://user-images.githubusercontent.com/67264863/144686568-00985ea3-bd53-4dd2-be9c-75ef45eefc29.png)

<b>-Body :</b>

![f1](https://user-images.githubusercontent.com/67264863/144686026-6b4bdac8-5b76-48a3-9a2c-743a8b704333.png)

<b>-Risposta :</b>

![f2](https://user-images.githubusercontent.com/67264863/144686065-be956894-0647-4ee4-85f7-c0f79b751cc3.png)
![f3](https://user-images.githubusercontent.com/67264863/144686067-b9c5c992-b66b-4671-84b6-164dbb420111.png)

</p>

# UML

<ul><li>CASO D'USO</li></ul>

![casod'uso](https://user-images.githubusercontent.com/67264863/144681628-93a3b475-ead9-4df3-84ec-35531db9cc74.png)

<ul><li>CLASSI</li></ul>

![main](https://user-images.githubusercontent.com/67264863/144682982-731ac431-a9be-4a72-a16d-db4be3a65c5c.png)
![controller](https://user-images.githubusercontent.com/67264863/144683000-eefb1815-e134-4a75-aebe-e2ed89021232.png)
![filter](https://user-images.githubusercontent.com/67264863/144683009-61b7558c-4da7-4aa4-934a-95c95f2123a8.png)
![statistic](https://user-images.githubusercontent.com/67264863/144683016-f38e23c2-704e-4349-aa55-0e4a4fa218ce.png)
![model](https://user-images.githubusercontent.com/67264863/144683091-ac9adac3-d2bf-4ac2-82f8-6c0f1039e8b8.png)
![service](https://user-images.githubusercontent.com/67264863/144683099-01c0afb1-78fc-4b23-a0b9-02350a315e3f.png)
![database](https://user-images.githubusercontent.com/67264863/144683106-4dc470a7-420c-41bf-88b7-7cd760e2e7bd.png)

<ul><li>SEQUENZE</li></ul>

![sequenzaLavoro](https://user-images.githubusercontent.com/67264863/144681853-25756916-e45a-4d4f-8636-b57ec1e83a2f.png)

![sequenzaFiltro](https://user-images.githubusercontent.com/67264863/144681845-2d8348de-cad4-4087-a513-778614c42010.png)

![sequenzaStatistics](https://user-images.githubusercontent.com/67264863/144681858-76b0bf77-8bdd-4b3f-adf6-c6fb2cdc93d8.png)

![sequenzaCittà](https://user-images.githubusercontent.com/67264863/144707412-a8d57b55-3bbd-44ed-af90-07f11138b27b.png)

# Autori

<table>
<tr><td>Nome e Cognome</td><td>Contributo</td><td>Email</td></tr>
<tr><td>Fiore Garzarella</td><td>50%</td><td><a href="S1089186@studenti.univpm.it">S1089186@studenti.univpm.it</a></td></tr>
<tr><td>Christian Parente</td><td>50%</td><td><a href="S1089031@studenti.univpm.it">S1089031@studenti.univpm.it</a></td></tr>
</table>

