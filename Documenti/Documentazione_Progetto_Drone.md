1. [Introduzione](#introduzione)

  - [Informazioni sul progetto](#informazioni-sul-progetto)

  - [Abstract](#abstract)

  - [Scopo](#scopo)

2. [Analisi](#analisi)

  - [Analisi del dominio](#analisi-del-dominio)
  
  - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)

  - [Use case](#use-case)

  - [Pianificazione](#pianificazione)

  - [Analisi dei mezzi](#analisi-dei-mezzi)

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
- Allievi coinvolti nel progetto:  Gianni Grasso, Samuele Ganci, Alessandro Aloise, Michea Colautti.
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

  Lo scopo del progetto è di creare un software in grado di collegare i movimenti delle nostre mani ad un drone.
  In pratica, grazie a un sensore chiamato `Leap Motion`, la nostra applicazione deve essere in grado di catturare e analizzare i movimenti 
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

### Interfaccia principale
La prima interfaccia che abbiamo definito è stata quella generale, ovvero il pannello che l'utente avrebbe visto una volta avviata l'applicazione.
![Progettazione int1](../Documenti/Progettazione/Design_Interfacce/DesingHome.png)
Come vedremo dopo, benché la struttura sia rimasta essenzialmente quella, quest'interfaccia ha subito alcune modifiche nel contenuto.
Questo è accaduto poiché procedendo con il progetto sono cambiate alcune idee e priorità.


#### [Interfaccia vista drone](####Interfaccia-vista-drone)

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

Per lo sviluppo di questo progetto il lavoro è stato suddiviso in tre principali sezioni, lo sviluppo delle classi relative al drone, ovvero la parte che concerne la comunicazione tra drone e utente, l'interfaccia principale e le diverse funzioni implementate, lo sviluppo delle classi relative al Leap Motion, ovvero la parte logica per quello che concerne la comunicazione tra drone e Leap Motion, la calibrazione dei comandi e la sensibilità dei movimenti del drone, e infine lo sviluppo delle classi  dell'Image Frame, ovvero la parte relativa alle varie interfacce contenenti le statistiche del drone e le rappresentazioni grafiche dei movimenti.

Per la sezione di progetto dedicata al drone sono state realizzate le seguenti classi:
1. Drone
2. CommandSequencer
3. CommandRecorder
4. Log
5. Status
6. Browser


Il funzionamento della comunicazione tra drone e utenti è piuttosto semplice, il drone possiede un proprio wi-fi e di conseguenza ha un suo ip e diverse porte sulla quale connettersi, alcune delle quali servono per la ricezione e l'invio di informazioni. È stata creata un'interfaccia principale grazie alla quale l'utente può interagire e usare tutte le funzionalità che offre il software. L'interfaccia principale è suddivisa in diverse sezioni, una sezione laterale per i comandi eseguiti, una barra in basso per eseguire alcune funzioni e visualizzare alcune statistiche come batteria e velocità, infine la parte principale al centro in cui si vedono tutti i dati relativi alla posizione e ai movimenti del drone.
Per prima cosa è stata realizzata la comunicazione tra leap motion e drone, quindi la parte relativa al pannello centrale, per poter instaurare una comunicazione tra leap motion e drone è stato creato un socket grazie alla quale l'utente client invia dei pacchetti su una determinata porta del drone, questi pacchetti sono delle semplici stringhe contenenti dei comandi che vengono interpretate dal drone tramite un suo protocollo interno. Quello che succede quindi, è che il leap motion continua a passare i dati che legge al drone, spedendoli in tempo reale tramite il socket, il drone riceve quindi questi pacchetti e si muove di conseguenza.



### DroneFrame

`DroneFrame` è una classe fondamentale, si tratta infatti del frame principale dell’applicazione. In esso sono contenuti tutti i due pannelli del package `DronePk`.
1.	`ComandiPanel`
2.	`FunzioniPanel`
Nel frame è inoltre contenuto il frame del package `ImageFrame`, `ImageFrame` appunto.

In riferimento a `ImageFrame` riteniamo opportuno riportate il costruttore del frame principale, in quanto al suo interno ci sono istruzioni molto interessanti:
Oltre a tutti i metodi per aggiungere le interfacce che citeremo qui sotto, c’è l’importante creazione della Thread di `ImageFrame` che, come specificheremo in seguito, viene eseguita qui per un semplice motivo, la rappresentazione del drone deve avvenire fin dal primo momento di vita dell’applicazione.

```
public DroneFrame() {
	initComponents();
	this.addMouseListener(this);
	this.setMinimumSize(new Dimension(800, 400));
	getContentPane().addComponentListener(this);
	Thread imgView = new Thread(imageFrame);
	imgView.start();
	switchKeyListenerOn();
	setReferences();
}
```

`DroneFrame` estende, come il nome suggerisce, `JFrame` ed implementa 3 interfacce:
1.	`KeyListener`
2.	`MouseListener`
3.	`ComponentListene`

Questo frame avrebbe potuto essere molto semplice, tuttavia abbiamo voluto aggiungere la possibilità di guidare il drone da tastiera. Questo ha portato ad una serie di complicazioni. Infatti per catturare i comandi da tastiera si necessita, chiaramente, di `KeyListener`. Per questo abbiamo i metodi qui, in modo possiamo poi inviare un segnale al pannello apposito, che si occuperà della gestione dei movimenti. Come esempio riportiamo il metodo KeyTyped:
```   
@Override
public void keyTyped(KeyEvent e) {
	comandiPanel.keyTypedC(e);
}
```

Tuttavia il progetto prevedeva che il drone si potesse guidare principalmente da `Leap Motion`
Perciò, per ragioni di sicurezza, abbiamo dovuto implementare un modo di catturare i tasti sempre. Questo però andava in contrasto con una nostra altra scelta: se il drone era in uso tramite `Leap Motion`, gli input da tastiera erano da ignorare, in quanto potevano causare problemi che, in alcuni nostri test, hanno portato il drone a schiantarsi.




## Status
Come suggerisce il nome, questa classe si occupa della gestione degli stati del drone, o meglio dei vari valori che fornisce il drone. Questa classe è una Thread, questo ci permette di avere in continuazione i dati che vengono salvati in un log, all'interno del metodo `public void run()`

Nelle righe di codice sottostanti troviamo la formattazione della data e la creazione del file di log, nel caso non esista ancora.
```java
dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Locale.ITALY);
log.creazioneFile();
```

Nelle righe di codice sottostanti possiamo vedere come andiamo a prendere il pacchetto che riceviamo dal drone e come lo andiamo a scomporre per prendere tutti i vari dati.
```java
packet = new DatagramPacket(buf, buf.length, address, port);
String received = new String(packet.getData(), 0, packet.getLength());
socket.receive(packet);
StringTokenizer st = new StringTokenizer(received, " ;");
```
Andando a analizzare un po' più approfonditamente: quello che facciamo e convertire il pacchetto che riceviamo in una stringa e poi andiamo a dividerla in base a quando troviamo il punto e virgola, in modo tale da avere tutti i vari dati singolaramente, ma non ancora del tutto puliti.

Per poterli finire di pulire dobbiamo fare il seguente passaggio:
```java
pitch = st.nextToken().substring(6);
roll = st.nextToken().substring(5);
yaw = st.nextToken().substring(4);
spX = st.nextToken().substring(4);
spY = st.nextToken().substring(4);
spZ = st.nextToken().substring(4);
```
Dato che il valore che riceviamo davanti ha ancora l'etichetta, dobbiamo pulire definitivamente con il metodo `substring()`: passando quanti caratteri vogliamo togliere rimuove i caratteri assegnati dalla parte iniziale della stringa lasciandoci i dati cosi puliti.

Nel caso della temperatura abbiamo un dato in fahrenheit mentre noi la vogliamo avere in gradi C°, quindi per fare la conversione facciamo il seguente calcolo
```java
temMinF = Integer.parseInt(templ.substring(6));
temMinC = (temMinF - 32) * 0.5;

```
Come prima cosa puliamo il dato e dopo di che facciamo il classico calcolo per la conversione della temperatura.

Dopo di che sempre nel metodo `public void run()` abbiamo il codice che troviamo qui sotto che serve per la gestione delle immagini.
```java
view.setPitch(Integer.parseInt(pitch));
view.setRoll(Integer.parseInt(roll));
view.setYaw(Integer.parseInt(yaw));
view.setAlt(Integer.parseInt(altezza));
```
Questi setter servono fornire i dati per spostare le immagini in tempo reale.

Dopo di che troviamo la scrittura del log:
```java
String valori = " Bat:" + bat
        + " TMax:" + temMaxC
        + " pitch:" + pitch
        + " roll:" + roll
        + " yaw:" + yaw
        + " Vx:" + spX
        + " Vy:" + spY
        + " Vz:" + spZ
        + " h:" + altezza
        + " Ax:" + agx
        + " Ay:" + agy
        + " Az:" + agz
        + " TCm: " + time;
String finale = dateFormat.format(data) + " " + ip + ":" + port + valori;
log.scritturaFile(finale);
```
Queso codice formatta la stringa e agginge delle informazioni da mettere nel log e poi fa un append al log già creato in precedenza.



### Log

La classe `log` è una classe molto semplice. Abbiamo deciso di implementarla dopo un po', su consiglio del docente, ma ci è stata molto utile. Log funziona solo grazie a a `Status`, come abbiamo detto quis sopra, essa infatti crea un istanza di `Log`, per poi ottenere tutti i dati che il drone invia in un unica lunga stringa. 
Ad oogni modo, questa stringa viene formattata e inviata a `Log` nel segunete modo:

```
log.scritturaFile(finale);
```
`finale` è appunto la stringa formattata.
Quello che `Log` fa, una volta invocato, è creare un file nella posizione designata, ovvero la nostra cartella log, e asseganrli come nome la data corrente. Poi una volta creato il file verrà aperto, scritto e poi richiuso.

Siccome la creazione del file è già stata affrontata in log, riportiamo solo il metodo più interessante:

***Scrittura del file***
```
fw.write(testo + '\n');
fw.flush();

```
NB: In quest'ultima porzione di codice biosngna gestire la `IOException`.


### Browser
Come suggerisce il nome questa classe si occupa della gestione del browser, in fatti in questa classe verranno attivati script diversi, la scelta verrà fatta in base al sistema operativo in uso. In entrambi i casi la live verrà visualizzata  in modo automatico. Infatti in questa classe abbiamo solo due metodi che sono `script()` e `openBrowser()`

Parliamo prima del metodo `script()`
```java
public void script() throws IOException {
    String os= System.getProperty("os.name").toLowerCase();
    if (os.contains("os")) {

        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh","-c"," ./RunLiveMac.sh");
        Process process=builder.start();
    } else {
        String path = "cmd /c start RunLiveWin.bat";
        Runtime rn = Runtime.getRuntime();
        Process pr = rn.exec(path);
    }
}
```
Questo metodo ci permette di identificare su che sistema operativo sta girando il nostro programma e, in base se é MacOS o Windows, fa partire due script diversi che si occupano di entrare in una cartella predefinita e attivare del codice di NodeJs.


Questo metodo serve a aprire una pagina internet.
```java
public void openBrowser() {
       String url = "http://localhost:3000/index.html";
       if (Desktop.isDesktopSupported()) {
           Desktop desktop = Desktop.getDesktop();
           try {
               desktop.browse(new URI(url));
           } catch (IOException | URISyntaxException e) {
               System.out.println("Error:" + e);
           }
       } else {
           Runtime runtime = Runtime.getRuntime();
           try {
               runtime.exec("xdg-open " + url);
           } catch (IOException e) {
               System.out.println("Error:" + e);
           }
       }
   }
```
Come possiamo vedere andiamo a parire la pagina `http://localhost:3000/index.html` su qui andremo a vedere la live che sarà stata caricata dallo script precedentemente accennato.



### ImageFrame

Per quanto riguarda invece l’implementazione della rappresentazione grafica del drone e della sua posizione sono state implementate queste classi:

1.	ImageFrame
2.	ImagePanelUp
3.	ImagePanelLat
4.	ImagePanelFront
5.	ImagePanelAlt
6.	ImageModel

Come il nome suggerisce, i 4 dati principali del drone (imbardata, beccheggio, rollio e altitudine) sono rappresentati nei 4 panelli.

ImageModel è invece un pannello speciale, che definisce il modello per la rappresentazione di un pannello: al suo interno sono infatti contenuti i metodi per ridimensionare le immagini, per ruotarle e per disegnarle.

Per far si che i pannelli potessero utilizzare i metodi, abbiamo dovuto creare una relazione tra i pannelli e il modello stesso. Per questo i pannelli estendono la classe modello.

***ImageFrame***

ImageFrame, come il nome suggerisce, è nato inizialmente per essere il Frame principale. Questo però è cambiato quando abbiamo deciso di implementare la Live, che avrebbe occupato gran parte della finestra come mostrato dalla progettazione, in  NodeJs e con una pagina web. Per questo ImageFrame è diventato un panello, che ha preso il posto della Live. Abbiamo mantenuto il nome tuttavia perché era ormai molto integrato con il resto dell’app, inoltre l’aggiunta di “Frame” nel nome suggerisce che sia un contenitore, aveva quindi più senso per noi lasciare lo stesso nome. 

Qui l’inizializzazione della classe ImageFrame:

```java
private void initComponents() {

GridLayout ImageFrameLayout = new GridLayout(2, 2);
	setLayout(ImageFrameLayout);
	imagePanelFront = new ImagePanelFront();
	imagePanelLat = new ImagePanelLat();
	imagePanelUp = new ImagePanelUp();
	imagePanelAlt = new ImagePanelAlt();
	add(imagePanelLat);
	add(imagePanelUp);
	add(imagePanelFront);
	add(imagePanelAlt);
}    
```
Come si può vedere al pannello principale vengono aggiunti i 4 pannelli secondari.


Per funzionare ImageFrame sfrutta la classe già menzionata “Status”. In essa sono contenuti dei metodi Setter che ci permettono di aggiornare i vari valori pich, yaw, roll, alt all’interno della classe. Questi setter, combinati con l’uso di una Thread, permettono l’aggiornamento continuo della rappresentazione del drone.

La Thread in questione viene fatta partire nell’esatto istante in cui l’applicazione si apre, infatti sfruttando l'istanza già creata dal Gui Builder, abbiamo istanziato una Thread con `ImageFrame` come parametro e poi l'abbiamo fatta partire.

```java
Thread imgView=new Thread(imageFrame1);
imgView.start();

```

Una volta partita la Thread, vengono continuamente richiamati i metodi dedicati al movimento delle 4 immagini nei pannelli secondari, ImagePanelUp differisce rispetto agli altri pannelli in quanto la classe ha un suo metodo paintCompoents, questò perché l’immagine del drone visto dall’alto, a volo di uccello in pratica, ha un formato differente rispetto a ImagePaenlFront e ImagePaenlLat. Queste ultime due sono infatti rettangolari, mentre ImagePanelUp è quadrata.

Il codice della Thread è riportato qui sotto.

```java
public void run() {
	imagePanelFront.moving(roll);
	imagePanelLat.moving(pitch);
	imagePanelAlt.setAltitude(alt);
	imagePanelUp.deg = yaw;
	imagePanelUp.validate();
	imagePanelUp.repaint();       
}

```
Dopo aver spiegato ImageFrame, passiamo a ImageModel

***ImageModel***

Come detto questa classe definisce un modello per la rappresentazione delle immagini. 
Al suo intenro sono infatti contenute le istanze di BufferedImage che ci serviranno nel programma, le istanze sono 3:

`public BufferedImage imageBig`: è l’immagine originale, che verrà direttaemnte presa dal file png.

`public BufferedImage rotatedImage`: è l’immagine temporanea che verrà ruotata.

`public BufferedImage image`: è l’immagine finale che poi verrà rappresentata.

Oltre alle istanze sono presenti altri 2 metodi di supporto.
Il primo è quello per il ridimensionamento delle immagini, esse infatti erano troppo grosse per poter stare nel nostro panello, era necessario ridurne di molto la dimensione.

Quello che fa il metodo ` resize` in pratica è prendere come argomento un immagine, che sarà ImageBig, e due attributi di tipo int che specificano larghezza e altezza. In seguito il metodo crea una nuova BufferdImage con dimensioni nuove, ma con lo stesso contenuto dell’immagine originale, poi la ritorna.

Il secondo metodo, `rotate`, funziona in maniera simile a quello precedente: prende una BufferdImage come input e un int che specifica la rotazione in gradi, poi tramite formule matematiche e l’uso di `Graphics2D`, usato anche da `resize` tra parentesi, permette di ruotare l’immagine con il metodo apposito. L’immagine ruotata viene poi ritornata.

Un terzo metodo fondamentale è `toBufferedImage`. Esso, data un’immagine di tipo `Image` come input permette di convertirla in BufferdImage.
Questo metodo si è reso necessario quando abbiamo creato il jar finale, e ci siamo accorti che le immagini non venivano mostrate, in quanto erano compresse nel file jar stesso.
Questo ci ha costretti a rendere delle immagini delle risorse della classe stessa, per poi essere prese e convertite, in quanto non era possibile creare delle BufferdImage direttamente. 
Ma esploreremo questo aspetto meglio più avanti.

L’ultimo metodo fondamnetale è, ovviamente, ` paintComponent`. Questo metodo viene usato da `ImagePanelFront` e `ImagePanelLat`; poiché i due pannelli contengono 2 immagini pressochè identiche nei rapporti di dimensione.

Questo metodo prende come prima cosa le dimensioni del pannello, per poi calcolare l’altezza dell’immagine in base alla larghezza data. Abbiamo infatti stabilito che l’altezza dovesse essere 1.5 volte in meno rispetto alla larghezza. In questo modo possiamo mantenere il rapporot giusto senza avere l’immagine stirata.
Dopo aver calcolato le dimensioni dell’immagine, essa può essere ridimensionata, viene ridotta arbitrariamente di 75,  per poi essere disegnata.

Abbiamo posto una particlare attenzione alla rappresentazione delle immagini ruotata, infatti abbiamo fatto variare la posizione y, aggiungendo o togliendo i gradi di rotazione.
Testando abbiamo scoperto infatti che questo aitua a mantenere l’immagine al centro del pannello. 

Qui c’è il codice di paintCompoent da noi creato:

```java
public void paintComponent(Graphics g) {
	panelH = getHeight();
	panelW = getWidth();
	g.clearRect(0, 0, panelW, panelH);
	panelH = (int) (panelW / 1.5);
	g.setColor(Color.black);
	int x, y = 0;
	if (imageBig != null) {	
		image = resize(imageBig, panelW - 75, panelH - 75);
		x = (this.getWidth() - image.getWidth()) / 2;
		y = (this.getHeight() - image.getHeight()) / 2;
		image = rotate(image, rotDeg);
		if (rotDeg > 0) {
			g.drawImage(image, x, y - rotDeg, this);
		} else {
			g.drawImage(image, x, y + rotDeg, this);
		}
	}
}
```
Ora è arrivato il momento di passare ai 4 frame dell'applicazione. Per trattare questa parte di codice abbiamo deciso di dividere la nostra documentazione in 3 parti distinte.

1. `ImagePanelLat`+`ImagePanelFront`
2. `ImagePanelUp`
3. `ImagePanelAlt`

Questo perché i primi due pannelli possiedono un codice pressoché identico, è quindi possibile semplificare la spiegazione.

***ImagePanelLat/Front***

Questi pannelli esportano essenzialmente 2 elementi, un metodo costruttore personalizzato e un metodo per gestire il movimento. Partiamo dal costruttore.

Come anticipato precedentemente, il costruttore ci permette di prendere l'immagine da file, per poi convertirla per essere utilizzata. Tuttavia prelevare quest'immagine ci pone di fronte a qualche difficoltà: una volta creato il file Jar infatti, non sarà più possibile prelevare le immagini semplicemente con il loro percorso, in quanto esse vengono compresse. 
Per ovviare a questo problema bisogna eseguire 2 semplici passaggi.

Come prima cosa dobbiamo spostare le immagini dalla loro cartella di origine, per posizionarle in un'altra cartella, idealmente in un posto facile e accessibile.
Dopo aver messo le immagini nella nuova locazione, bisogna aggiungere la cartella delle immagini come `ClassPath` al progetto di NetBeans, aggiungendolo alle altre librerie già presenti.

Il secondo passo sarà prelevare le immagini come “risorsa di classe”, e questo può essere fatto nel seguente modo:

```java
 public ImagePanelFront() {
	ImageIcon icon;
	icon = new ImageIcon(getClass().getClassLoader().getResource("DroneFrontale.png"));
	Image image = icon.getImage();
	imageBig=toBufferedImage(image);
}
```
È importante che le immagini siano prese dapprima come `Icon`, in quanto questo tipo di immagine è il più consigliato per essere usato come contenitore per delle risorse di immagini. 
In seguito questa icona è convertirla in un immagine e, tramite il metodo citato prima, in una `BufferdImage`.

Il secondo metodo importante è, come detto, il metodo per il movimento. Il principio è molto semplice, viene passato un parametro con la pendenza in gradi, dopo aver verificato se la pendenza è minore rispetto alla massima consentita, l'immagine viene ruotata e aggiornata.

Abbiamo fatto un controllo sull'inclinazione massima in quanto ci siamo accorti che in alcuni casi l'immagine del drone fuoriusciva dai bordi del pannello. Per questo abbiamo deciso di imporre un limite che consigliasse l'integrità dell'immagine con una rappresentazione realistica del drone inclinato.

Ecco il metodo per il moviemento da noi implementato:

```java
public void moving(int rotate) {
	if (rotate < 0) {
		if (rotate >= -MAXDEG) {
			rotDeg = -rotate;
			validate();
			repaint();
		}
	} else {
		if (rotate <= MAXDEG) {
			rotDeg = -1 * rotate;
			validate();
			repaint();
		}
	}
}
```

***ImagePanelUp***
Questa classe differisce leggermente dalle due precedenti, infatti a cambiare è il rapporto dell’immagine.

Tuttavia la logica è pressoché la stessa, il costruttore prende l’immagine allo stesso modo, ma al posto di esserci un metodo di movimento che sfrutta il `paintComponent` definito nel modello `ImagePanelUp` ha un suo metodo paint.
Esso è molto simile a quello visto nel modello di panello, con la differenza del calcolo della dimensione dell’immagine. In questa classe l’immagine assume la dimensione più piccola possibile, data dalla larghezza e dall’altezza del pannello.
```java
  if (panelW > panelH) {
            panelW = panelH;

        } else {
            panelH = panelW;
        }
```

Il codice che permette invece di disegnare l’immagine è invece molto simile a quello mostrato in `ImageModel`. Esso permette di ridimensionare l’immagine, ruotarla e disegnarla; ecco un estratto del codice:

```java
if (imageBig != null) {
	image = resize(imageBig, panelW - 75, panelH - 75);
	int x = (this.getWidth() - image.getWidth()) / 2;
	int y = (this.getHeight() - image.getHeight()) / 2;
	rotatedImage = rotate(image, deg);
	g.drawImage(rotatedImage, x, y, this);           
}
```
***ImagePanelAlt***

Quest ultimo panelo è il più semplice di tutti. Infatti non contiene nemmeno un immagine, 
tramite il parametro che viene aggiornato, anche il `JLabel` contenete il dato viene aggiornato.
Per una maggior completezza il dato dell'altezza è dato in metri, centimetri e piedi.
Vine creata una stringa con dentro tutti questi valori e poi essa viene assegnata al JLabel.
```java
String text = altitude + " cm" + '\n'
	+ altitude / 100 + " m" + "\n"
	+ stAlt / 30.48 + " ft";
	
	alt.setText("<html>" + text.replaceAll("<", "&lt;")
		.replaceAll(">", "&gt;")
		.replaceAll("\n", "<br/>") + "</html>");
```
Per la formattazione abbiamo usato i tag HTML, ma poi essi vengono rimossi una volta inserita la stringa nel Label.



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
