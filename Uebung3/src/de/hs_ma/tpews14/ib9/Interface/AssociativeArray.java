package de.hs_ma.tpews14.ib9.Interface;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import de.hs_ma.tpews14.ib9.Objects.AArray;

public interface AssociativeArray <K,V> {

		/**
		 *  leert den Baum, indem root null gesetzt wird.
		 */
		public void clear();
		
		/**
		 *  Es wird ein Wert uebergeben.
		 *  Dann wird der Baum solange durchgegasngen bis der Wert im Baum
		 *  gefunden wurde.
		 *  Wenn der Baum den Wert enth�lt wird true zur�ckgegeben; 
		 *  wenn nicht dann false.
		 * @param v
		 * @return true/ false
		 */
		public boolean containsValue(V v);
		
		/**
		 * gleich wie containsValue nur mit einem Schluessel.
		 * @param k
		 * @return true/false
		 */
		public boolean containsKey(K k);
		
		/**
		 *  Der Baum wird nach ienem Schl�ssel durchsucht.
		 *  Wenn gefunden, dann wird der Wert des Schuessels zur�ckgegeben 
		 *  und wenn nicht gefunden wird null zur�ckgegeben.
		 * @param k
		 * @return den zugeh�rigen Wert von dem �bergebenem Schl�ssel
		 */
		public V get(K k);
		
		/**
		 *  Wir schauen ob root leer ist.
		 *  Wenn dies der Fall ist wird true zur�ckgegeben wenn im Baum 
		 *  etwas enthalten ist, sprich root != null wird false zur�ckgegeben.
		 * @return true /false
		 */
		public boolean isEmpty();
		
		/**
		 *  Erstellt einen neuen Knoten mit den Uebergebeparametern
		 *  und f�gt diesen an der richtigen Stelle des Baums hinzu.
		 *  Daf�r muss ueber�rueft werden, ob der neue Knoten links oder rechts
		 *  vom verglichenem Knoten eingeordnet werden muss.
		 *  Dies wird rekursiv solange wiederholt bis der Knoten an der richtigen
		 *  Stelle eingefuegt wurde.
		 * @param k
		 * @param v
		 */
		public void put(K k, V v);
		
		/**
		 *  benutzt den biConsumer um alle Schl�ssel eines uebergebenen Baumes in
		 *  den jetztigen Baum hinzu zufuegen.  Der biConsumer geht den 
		 *  uebergebenen Baum durch und mithilfe der put-Methode werden die 
		 *  Schluessel eingefuegt.
		 *  
		 * @param b
		 */
		public void putAll(AArray <K,V> b);
		
		/**
		 * Durchsucht den Baum nach einem Key und l�scht diesen dann.
		 * Sie liefert den zugeh�rigen Wert des Schluessel zur�ck.
		 * Auserdem ordnet sie die Kindknoten des gel�schten Knotens
		 * wieder in den Baum in der richtigen Reihenfolge ein.
		 * 
		 * @param v
		 * @return Wert des geloeschten Schluessel-Wert-Paares
		 */
		public V remove (K v);
		
		/**
		 * Ruft eine Hilfsmethode auf, die den Baum durchgeht und dann bei
		 * jedem Knoten 1 hochzaehlt.
		 * 
		 * @return Anzahl der Elemente im Baum
		 */
		public int size();
		
		/**
		 * Sucht mithilfe des Hashcodes einen Schluessel und ersetzt den 
		 * aktuellen Wert mit dem uebergebenem.
		 * 
		 * @param k
		 * @param v
		 */
		public void update(K k,V v);
		
		/**
		 * geht den Baum durch und wird durch einen Lambdaausdruck
		 * aufgerufen.
		 * 
		 * @param b
		 */
		public void forEach(BiConsumer <K,V> b);
		
		/**
		 * ruft die putALL-Methode auf und fuegt alle Schluessel-Wert-Paare
		 * des aktuellen Baums zum uebergebenem Baum hinzu.
		 * 
		 * @param b
		 */
		public void extractAll(AArray<K,V> b);
		
		/**
		 * geht den Baum durch und wird durch einen Lambdaausdruck
		 * aufgerufen
		 * 
		 * @param b
		 * @return einen neuen Wert der durch den Lambdaausdruck veraendert wurde
		 */
		public AArray<K,V> map(BiFunction<K, V,V> b);
	}
