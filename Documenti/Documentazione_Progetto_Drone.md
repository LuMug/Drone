1. [Introduzione](#introduzione)

  - [Informazioni sul progetto](#informazioni-sul-progetto)

  - [Abstract](#abstract)

  - [Scopo](#scopo)

2. [Analisi](#analisi)

  - [Analisi del dominio](#analisi-del-dominio)
  
  - [Analisi dei mezzi](#analisi-dei-mezzi)

  - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)

  - [Use case](#use-case)

  - [Pianificazione](#pianificazione)

3. [Progettazione](##Progettazione)
  - [Design delle interfacce](###design-delle-interfacce)
  - - [Interfaccia principale](####Interfaccia-principale)
  - - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)
  - - [Interfaccia vista drone](####Interfaccia-vista-drone)



  - [Design dei dati e database](#design-dei-dati-e-database)

4. [Implementazione](#implementazione)

5. [Test](#test)

  - [Protocollo di test](#protocollo-di-test)

  - [Risultati test](#risultati-test)

  - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

6. [Consuntivo](#consuntivo)

7. [Conclusioni](#conclusioni)

  - [Sviluppi futuri](#sviluppi-futuri)

  - [Considerazioni personali](#considerazioni-personali)

8. [Sitografia](#sitografia)

9. [Allegati](#allegati)


## Introduzione

### Informazioni sul progetto
- Allievi coinvolti nel progetto: Samuele Ganci, Alessandro Aloise, Michea Colautti, Gianni Grasso.
- Classe: I3AA, I3AC, Scuola Arti e Mestieri Trevano, sezione Informatica. 
- Docenti responsabili: Luca Muggiasca, Geo Petrini.
- Data inizio: 14 gennaio 2021.
- Data di fine: 13 maggio 2021.

### Abstract

  > *Nowadays, technology around us is costantly evolving, even becoming vital. Thanks
  to computer system, the way we entertain ourselves has changed in recent times,
  technology enternains us. Recently, aumented reality devices such as VR devices,
  hands and arms sensors, and more. These things have become increasingly common in the
  market. In this project we managed to implement piloting a drone with our hands, thanks
  to the help of a device called Leap Motion. With little money now you can buy
  a Leap Motion and a Drone to be able to enjoy driving the DJI Tello using only
  your hands in a very intuitive and simple way.*

### Scopo

  Lo scopo del progetto, è di creare un software in grado di collegare i movimenti delle nostre mani ad un drone.
  In pratica, grazie a un sesore chiamato `Leap Motion`, la nostra applicazione deve essere in grado di catturare e analizzare i movimenti 
  delle mani e, dopo averli processati, trasmetterli al drone. Per farlo dobbiamo usare la tecnologia `UDP` (**U**ser **D**atagram **P**rotocol) e 
  l'`SDK` installata di fabbrica sul drone.
  Dobbiamo, oltre a creare il sistema di pilotaggio, instaurare una comunicazione che permetta lo scambio di dati del drone; non solo dati come l'inclinazione,       l'altitudine, ma anche dati statistici come la batteria.
  
## Analisi

### Analisi del dominio

  È stato richiesto di creare un'interfaccia di controllo utile a pilotare un drone DJI Tello, il
  movimento del velivolo deve avvenire tramite lo spostamento di entrambe le mani, inoltre, deve
  essere visualizzato a schermo il video del drone in streaming. Una mano si occupa di imbardata,
  beccheggio e rollio, l'altra invece dell'altitudine. Deve inoltre essere possibile registrare una
  sequenza di comandi per poi poterla far riprodurre dal drone successivamente in modo autonomo.
  
  Deve essere inoltre creata un'ulteriore interfaccia che deve avere 4 riquadri, che rappresenteranno
  in 2D in forma stilizzata rispettivamente l'imbardata, il beccheggio, il rollio e l'altitudine del drone.
  
  Le interfacce perciò si devono occupare dei dati ricevuti dal drone, e successivamente
  fare in modo di renderli reperibili in una pagina web sotto forma di statistica.
  
  Il tutto deve essere programmato in Java.

### Analisi e specifica dei requisiti

   
|               |**ID: Req-001**|
|--------------|-----------------------------|
|**Nome**      | Interfaccia controllo Drone |
|**Priorità**  | 1                            |
|**Versione**  | 1.1                         |
|**Note**      | Utilizzare Java. La connessione al drone deve avvenire tramite protocollo UDP|
|**001**       | Realizzare un'interfaccia utile a pilotare il drone con i tasti virtuali del programma|
|**002**       | Implementare il pilotaggio con i tasti fisici del PC|
|**003**       | Implementare il pilotaggio con il Leap Motion, la mano sinistra si occupa del movimento verticale, mentre la destra si occupa di tutti gli altri movimenti|
|**004**       | Realizzare il frame con lo streaming del video del drone|
|**005**       | Implementare la funzione di salvataggio di sequenze di comandi. Successivamente fare in modo di farle riprodurre dal drone in modo autonomo|  

|       |**ID: Req-002**|
|-------|-----------|
|**Nome**| Interfaccia posizione Drone |
|**Priorità**|1|
|**Versione**|1.0|
|**Note**|Utilizzare Java|
|        |**Sotto requisiti**|
|**001**|Realizzare un'interfaccia con 4 riquadri, raffiguranti rispettivamente l’imbardata, il beccheggio, il rollio e l’altitudine del drone. Le immagini devono essere in 2D e stilizzate |

|    |**ID: Req-003**|
|----|---------------|
|**Nome**| Interfaccia statistiche |
|**Priorità**|1|
|**Versione**|1.0|
|**Note**|Inizialmente sito web, su accordo è stato modificato in interfaccia. Utilizzare Java|
|        |**Sotto requisiti**|
|**001**|Realizzare un'ulteriore interfaccia che rappresenta i dati ritornati dal drone sottoforma di statistica.|

### Use case

Ecco il nostro Use Case
![Use Case](../Documenti/Progettazione/Use_Case/UseCase.png)

### Pianificazione

Per la pianificazione alleghiamo il Gantt preventivo da noi stabilito:
![Ganttpreventivo](../Documenti/Gantt/GANTT_Preventivo_Completo.jpg)


### Analisi dei mezzi

 **Software**
 - Java JDK 14.0.2
 - Leap Motion SDK 3.2.1
 - Tello SDK 2.0
 - Apache Netbeans IDE 12.0
 
 **Hardware**
- Laptop personali
- PC scolastici
- Drone DJI Tello
- Leap Motion

## Progettazione


### Design delle interfacce

###Interfaccia principale
La prima interfaccia che abbiamo definito è stata quella generale, ovvero il pannello che l'utente avrebbe visto una volta avviata l'applicazione.
![Progettazione int1](../Documenti/Progettazione/Design_Interfacce/DesingHome.png)
Come vedremo dopo, benché la struttura sia rimasta essenzialmente quella, quest'interfaccia ha subito alcune modifiche nel contenuto.
Questo è accaduto poiché procedendo con il progetto sono cambiate alcune idee e priorità.


####[Interfaccia vista drone(####Interfaccia-vista-drone)

Un’altra interfaccia importante da progettare era quella della vista del drone. Quest'ultima è molto semplice, ed è rimasta essenzialmente la stessa, ma è stato importante pensare come rappresentare i dati che ci venivano richiesti, ovvero la rappresentazione grafica del drone. Inizialmente abbiamo pensato a delle foto ferme, con delle frecce che indicassero i movimenti. Tuttavia ci siamo accorti che creare uno schizzo del drone e muovere quello era molto più.

![Progettazione int2](../Documenti/Progettazione/Design_Interfacce/DesingVistaDrone.png)

### Design procedurale


Dopo aver progettato le due interfacce principali abbiamo pensato di creare uno schema di flusso dell'applicazione.
Sapevamo più o meno come procedere e come impostare il nostro progetto, ma abbiamo comunque voluto mettere le nostre idee su "carta".

![Progettazione int2](../Documenti/Progettazione/Schema_Flusso/SchemaFlusso.png)

In quest'immagine s si può vedere la struttura schematizzata della nostra applicazione. 

1. Il Leap Motion, tramite la sua Liberia dedicata, passa i dati al computer e il nostro programma li legge, e li interpreta.
2. Dopo avere ottenuto i dati grezzi, il programma gli elabora, converte dati come l'inclinazione della mano o la velocità della stessa, in istruzioni che il drone può interpretare.
3. Come terzo passaggio i dati vengono inviati tramite socket al drone, un socket UDP.
4. Una volta inviati i droni vengono elaborati dall'SDK presente sul chip nel drone.
5. Quando e mentre i dati vengono elaborati dal drone, esso risponde con dei messaggi di conferma. Ma non solo. Infatti il drone invia anche dati sulla sua batteria, sulla sua posizione [x,y,z], ma anche dati sulla sua inclinazione. Questi dati vengono interpretatati dal nostro programma e elaborati. Questo ci permette, per esempio, di far funzionare la rappresentazione grafica del drone.

### Design dell’architettura del sistema

***<Inseriere diagramma delle classi>***

Per il nostro progetto abbiamo deciso di procedere in maniera modulare. Infatti il progetto finale è una combinazione di più


## Implementazione

In questo capitolo dovrà essere mostrato come è stato realizzato il
lavoro. Questa parte può differenziarsi dalla progettazione in quanto il
risultato ottenuto non per forza può essere come era stato progettato.

Sulla base di queste informazioni il lavoro svolto dovrà essere
riproducibile.

In questa parte è richiesto l’inserimento di codice sorgente/print
screen di maschere solamente per quei passaggi particolarmente
significativi e/o critici.

Inoltre dovranno essere descritte eventuali varianti di soluzione o
scelte di prodotti con motivazione delle scelte.

Non deve apparire nessuna forma di guida d’uso di librerie o di
componenti utilizzati. Eventualmente questa va allegata.

Per eventuali dettagli si possono inserire riferimenti ai diari.

## Test

### Protocollo di test

Definire in modo accurato tutti i test che devono essere realizzati per
garantire l’adempimento delle richieste formulate nei requisiti. I test
fungono da garanzia di qualità del prodotto. Ogni test deve essere
ripetibile alle stesse condizioni.


|Test Case      | TC-001                               |
|---------------|--------------------------------------|
|**Nome**       |Import a card, but not shown with the GUI |
|**Riferimento**|REQ-012                               |
|**Descrizione**|Import a card with KIC, KID and KIK keys with no obfuscation, but not shown with the GUI |
|**Prerequisiti**|Store on local PC: Profile\_1.2.001.xml (appendix n\_n) and Cards\_1.2.001.txt (appendix n\_n) |
|**Procedura**   | - Go to “Cards manager” menu, in main page click “Import Profiles” link, Select the “1.2.001.xml” file, Import the Profile - Go to “Cards manager” menu, in main page click “Import Cards” link, Select the “1.2.001.txt” file, Delete the cards, Select the “1.2.001.txt” file, Import the cards |
|**Risultati attesi** |Keys visible in the DB (OtaCardKey) but not visible in the GUI (Card details) |


### Risultati test

Tabella riassuntiva in cui si inseriscono i test riusciti e non del
prodotto finale. Se un test non riesce e viene corretto l’errore, questo
dovrà risultare nel documento finale come riuscito (la procedura della
correzione apparirà nel diario), altrimenti dovrà essere descritto
l’errore con eventuali ipotesi di correzione.

### Mancanze/limitazioni conosciute

Descrizione con motivazione di eventuali elementi mancanti o non
completamente implementati, al di fuori dei test case. Non devono essere
riportati gli errori e i problemi riscontrati e poi risolti durante il
progetto.

## Consuntivo

Consuntivo del tempo di lavoro effettivo e considerazioni riguardo le
differenze rispetto alla pianificazione (cap 1.7) (ad esempio Gannt
consuntivo).

## Conclusioni

Quali sono le implicazioni della mia soluzione? Che impatto avrà?
Cambierà il mondo? È un successo importante? È solo un’aggiunta
marginale o è semplicemente servita per scoprire che questo percorso è
stato una perdita di tempo? I risultati ottenuti sono generali,
facilmente generalizzabili o sono specifici di un caso particolare? ecc

### Sviluppi futuri
  Migliorie o estensioni che possono essere sviluppate sul prodotto.

### Considerazioni personali
  Cosa ho imparato in questo progetto? ecc

## Bibliografia

### Bibliografia per articoli di riviste
1.  Cognome e nome (o iniziali) dell’autore o degli autori, o nome
    dell’organizzazione,

2.  Titolo dell’articolo (tra virgolette),

3.  Titolo della rivista (in italico),

4.  Anno e numero

5.  Pagina iniziale dell’articolo,

### Bibliografia per libri


1.  Cognome e nome (o iniziali) dell’autore o degli autori, o nome
    dell’organizzazione,

2.  Titolo del libro (in italico),

3.  ev. Numero di edizione,

4.  Nome dell’editore,

5.  Anno di pubblicazione,

6.  ISBN.

### Sitografia

1.  URL del sito (se troppo lungo solo dominio, evt completo nel
    diario),

2.  Eventuale titolo della pagina (in italico),

3.  Data di consultazione (GG-MM-AAAA).

**Esempio:**

-   http://standards.ieee.org/guides/style/section7.html, *IEEE
    Standards Style Manual*, 07-06-2008.

## Allegati

Elenco degli allegati, esempio:

-   Diari di lavoro

-   Codici sorgente/documentazione macchine virtuali

-   Istruzioni di installazione del prodotto (con credenziali
    di accesso) e/o di eventuali prodotti terzi

-   Documentazione di prodotti di terzi

-   Eventuali guide utente / Manuali di utilizzo

-   Mandato e/o Qdc

-   Prodotto

-   …
