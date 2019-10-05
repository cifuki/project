package test;
import java.io.Closeable;
public class Test {

	public boolean containsImage ( Name image )
	{
		return containsImage ( "save" + Image ) ;
	}
	public final void store ( OutputStream stream, char [ ] password ) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException
	{
    	if ( ! isInit )
    	{
        	throwNotInitialized ( ) ;
    	}
    	implSpi .engineStore ( stream, password ) ;
	}
	@ SuppressWarnings ( "unchecked" ) 
	public RegistryContext ( String host, int port, Hashtable < ?, ? > env ) throws NamingException
	{
    	environment = ( env == null ) ? new Hashtable < String, Object > ( 5 ) : ( Hashtable < String, Object > ) env ;
    	if ( environment .get ( SECURITY_MGR ) != null )
    	{
        	installSecurityMgr ( ) ;
    	}
    	if ( ( host != null ) && ( host . charAt ( 0 ) == '[' ) )
    	{
        	host = host . substring ( 1, host . length ( ) - 1 ) ;
    	}
    	RMIClientSocketFactory socketFactory = ( RMIClientSocketFactory ) environment . get ( SOCKET_FACTORY ) ;
    	registry = getRegistry ( host, port, socketFactory ) ;
    	this . host = host ;
    	this . port = port ;
	}
	public int singleNumberWithMap ( int [ ] nums )
	{
    	Map < Integer, Integer > map = new HashMap < Integer, Integer > ( ) ;
    	for ( int i : nums )
    	{
        	if ( map . containsKey ( i ) )
        	{
            	map . put ( i, map . get ( i ) + 1 ) ;
        	}
        	else
        	{
            	map . put ( i, 1 ) ;
        	}
    	}
    	for ( Map . Entry < Integer, Integer > entry : map . entrySet ( ) )
    	{
        	if ( entry . getValue ( ) < 3 )
        	{
            	return entry . getKey ( ) ;
        	}
    	}
    	for ( Map . Entry < Integer, Integer > entry : map . entrySet ( ) )
    	{
        	if ( entry . getValue ( ) < 3 )
        	{
            	return entry . getKey ( ) ;
        	}
    	}
    	for ( Object o : map . entrySet ( ) )
    	{
        	Map . Entry entry = ( Map . Entry ) o ;
        	if ( ( Integer ) entry . getValue ( ) == 1 )
        	{
            	return ( Integer ) entry . getKey ( ) ;
        	}
    	}
    	return 0 ;
	}
	public void setActions ( Action [ ] actions )
	{
    	this . actions = ( actions == null ) ? null : actions . clone ( ) ;
	}
	public void pauseProcessing ( final double time )
	{
    	Vector < Core > cores = this . getCores ( ) ;
    	erator < Core > iter = cores . iterator ( ) ;
    	wle ( iter . hasNext ( ) )
    	{
        	Core core = iter . next ( ) ;
        	co . pauseProcessing ( time ) ;
    	}
	}
	public float bottom ( float margin )
	{
    	reurn pageSize . bottom ( marginBottom + margin );
	}
	public Icon getIconForButton ( String buttonName )
	{
    	Sting fileName = ( String ) BUTTON_NAMES . get ( buttonName ) ;
    	if ( fileName == null ) return null ;
    	ImageIcon icon = ( ImageIcon ) BUTTON_CACHE . get ( fileName ) ;
    	if ( icon == NULL ) return null ;
    	if ( icon != null ) return icon ;
    	try
    	{
        	String retrieveName ;
        	if ( UISettings . SMALL_ICONS . getValue ( ) ) retrieveName = fileName + "_small" ;
        	else retrieveName = fileName + "_large" ;
        	icon = ResourceManager . getThemeImage ( retrieveName ) ;
        	BUTTON_CACHE . put ( fileName, icon ) ;
    	}
    	catch ( MissingResourceException mre )
    	{
        	try
        	{
            	icon = ResourceManager . getThemeImage ( fileName ) ;
            	BUTTON_CACHE . put ( fileName, icon ) ;
        	}
        	catch ( MissingResourceException mre2 )
        	{
            	BUTTON_CACHE . put ( fileName, NULL ) ;
        	}
    	}
    	return icon ;
	}
	public static String encodeObject ( java . io . Serializable serializableObject )
	{
    	return encodeObject ( serializableObject, NO_OPTIONS ) ;
	}
	public void unparsedEntityDecl ( String name, XMLResourceIdentifier identifier, String notation, Augmentations augs ) throws XNIException
	{
    	if ( fValidation )
    	{
        	fNDataDeclNotations . put ( name, notation ) ;
    	}
    	if ( fDTDGrammar != null ) fDTDGrammar . unparsedEntityDecl ( name, identifier, notation, augs ) ;
    	if ( fDTDHandler != null )
    	{
        	fDTDHandler . unparsedEntityDecl ( name, identifier, notation, augs ) ;
    	}
	}
	@ Override 
	public void close ( ) throws IOException
	{
    	synchronized ( lock )
    	{
        	if ( decoder != null )
        	{
            	decoder . reset ( ) ;
        	}
        	decoder = null ;
        	if ( in != null )
        	{
            	in . close ( ) ;
            	in = null ;
        	}
    	}
	}
	public RGBColor toGreyScale ( )
	{
    	return new RGBColor ( 0.30 * getRed ( ) + 0.59 * getGreen ( ) + 0.11 * getBlue ( ) ) ;
	}
	public Builder before ( Animator anim )
	{
    	Node node = mNodeMap . get ( anim ) ;
    	if ( node == null )
    	{
        	node = new Node ( anim ) ;
        	mNodeMap . put ( anim, node ) ;
        	mNodes . add ( node ) ;
    	}
    	Dependency dependency = new Dependency ( mCurrentNode, Dependency . AFTER ) ;
    	node . addDependency ( dependency ) ;
    	return this ;
	}
	final void runWorker ( Worker w )
	{
    	Thread wt = Thread . currentThread ( ) ;
    	Runnable task = w . firstTask ;
    	w . firstTask = null ;
    	w . unlock ( ) ;
    	boolean completedAbruptly = true ;
    	try
    	{
        	while ( task != null || ( task = getTask ( ) ) != null )
        	{
            	w . lock ( ) ;
            	if ( ( runStateAtLeast ( ctl . get ( ), STOP ) || ( Thread . interrupted ( ) && runStateAtLeast ( ctl . get ( ), STOP ) ) ) && ! wt . isInterrupted ( ) ) wt . interrupt ( ) ;
            	try
            	{
                	beforeExecute ( wt, task ) ;
                	Throwable thrown = null ;
                	try
                	{
                    	runTask ( task ) ;
                	}
                	catch ( RuntimeException x )
                	{
                    	thrown = x ;
                    	throw x ;
                	}
                	catch ( Error x )
                	{
                    	thrown = x ;
                    	throw x ;
                	}
                	catch ( Throwable x )
                	{
                    	thrown = x ;
                    	throw new Error ( x ) ;
                	}
                	finally
                	{
                    	afterExecute ( task, thrown ) ;
                	}
            	}
            	finally
            	{
                	task = null ;
                	w . completedTasks ++ ;
                	w . unlock ( ) ;
            	}
        	}
        	completedAbruptly = false ;
    	}
    	finally
    	{
        	processWorkerExit ( w, completedAbruptly ) ;
    	}
	}
	public Package getPackage ( )
	{
    	return Package . getPackage ( this ) ;
	}
	public void doPostSubmitCall ( Item submitItem, HtmlForm form )
	{
    	if ( form == null )
    	{
        	return ;
    	}
    	StringBuffer sb = new StringBuffer ( ) ;
    	Hashtable elements = form . getFormElements ( this . formListener, submitItem ) ;
    	Enumeration enumeration = elements . keys ( ) ;
    	while ( enumeration . hasMoreElements ( ) )
    	{
        	String name = ( String ) enumeration . nextElement ( ) ;
        	String value = ( String ) elements . get ( name ) ;
        	value = TextUtil . encodeUrl ( value ) ;
        	sb . append ( name ) . append ( '=' ) . append ( value ) ;
        	if ( enumeration . hasMoreElements ( ) )
        	{
            	sb . append ( '&' ) ;
        	}
    	}
    	this . browser . go ( this . browser . makeAbsoluteURL ( form . getAction ( ) ), sb . toString ( ) ) ;
	}
	public static String getNextTag ( String xmlData, int position )
	{
    	String nextTag = null ;
    	if ( xmlData != null && ! xmlData . isEmpty ( ) && position < xmlData . length ( ) && xmlData . substring ( position ) . contains ( "<" ) )
    	{
        	while ( xmlData . charAt ( position ) != '<' )
        	{
            	position ++ ;
        	}
        	int startIndex = position ;
        	if ( xmlData . substring ( position ) . contains ( ">" ) )
        	{
            	while ( xmlData . charAt ( position ) != '>' )
            	{
                	position ++ ;
            	}
            	nextTag = xmlData . substring ( startIndex, position + 1 ) ;
        	}
    	}
    	return nextTag ;
	}
	public Date engineGetCreationDate ( String alias )
	{
    	KeyEntry entry = entries . get ( alias . toLowerCase ( ) ) ;
    	if ( entry != null )
    	{
        	return new Date ( entry . date . getTime ( ) ) ;
    	}
    	else
    	{
        	return null ;
    	}
	}
	public static String encode ( String p )
	{
    	if ( p == null )
    	{
        	return "" ;
    	}
    	if ( ! "1.0" . equals ( outVersion ) )
    	{
        	return p ;
    	}
    	try
    	{
        	String p1 = URLEncoder . encode ( p, CHAR_SET ) ;
        	return p1 ;
    	}
    	catch ( UnsupportedEncodingException e )
    	{
        	log . warn ( "System-doesn't-support-" + CHAR_SET, e ) ;
        	return p ;
    	}
	}
	public double dotProduct ( OpenMapRealVector v )
	{
    	checkVectorDimensions ( v . getDimension ( ) ) ;
    	boolean thisIsSmaller = entries . size ( ) < v . entries . size ( ) ;
    	Iterator iter = thisIsSmaller ? entries . iterator ( ) : v . entries . iterator ( ) ;
    	OpenIntToDoubleHashMap larger = thisIsSmaller ? v . entries : entries ;
    	double d = 0 ;
    	while ( iter . hasNext ( ) )
    	{
        	iter . advance ( ) ;
        	d += iter . value ( ) * larger . get ( iter . key ( ) ) ;
    	}
    	return d ;
	}
	public void addClientSocketListener ( ClientSocketListener listener )
	{
    	if ( listener == null ) throw new NullPointerException ( ) ;
    	listeners . add ( listener ) ;
	}
	public static void addURL ( URL u ) throws IOException
	{
    	ClassloaderUtil clu = new ClassloaderUtil ( ) ;
    	URLClassLoader sysLoader = ( URLClassLoader ) clu . getClass ( ) . getClassLoader ( ) ;
    	URL urls [ ] = sysLoader . getURLs ( ) ;
    	for ( URL url : urls )
    	{
        	if ( url . toString ( ) . toLowerCase ( ) . equals ( u . toString ( ) . toLowerCase ( ) ) )
        	{
            	System . err . println ( "URL-" + u + "-is-already-in-the-CLASSPATH" ) ;
            	return ;
        	}
    	}
    	Class < ? > sysclass = URLClassLoader . class ;
    	try
    	{
        	Method method = sysclass . getDeclaredMethod ( "addURL", parameters ) ;
        	method . setAccessible ( true ) ;
        	method . invoke ( sysLoader, new Object [ ] { u } ) ;
    	}
    	catch ( Throwable t )
    	{
        	t . printStackTrace ( ) ;
        	throw new IOException ( "Error,-could-not-add-URL-to-system-classloader" ) ;
    	}
	}
	final void addProcessToGcListLocked ( ProcessRecord proc )
	{
    	boolean added = false ;
    	for ( int i = mProcessesToGc . size ( ) - 1 ; i >= 0 ; i -- )
    	{
        	if ( mProcessesToGc . get ( i ) . lastRequestedGc < proc . lastRequestedGc )
        	{
            	added = true ;
            	mProcessesToGc . add ( i + 1, proc ) ;
            	break ;
        	}
    	}
    	if ( ! added )
    	{
        	mProcessesToGc . add ( 0, proc ) ;
    	}
	}
	public static void snapshot ( )
	{
    	Dimension dim = getInstance ( ) . component . getPreferredSize ( ) ;
    	java . awt . Rectangle rect = new java . awt . Rectangle ( 0, 0, dim . width, dim . height ) ;
    	BufferedImage image = new BufferedImage ( rect . width, rect . height, BufferedImage . TYPE_INT_RGB ) ;
    	Graphics g = image . getGraphics ( ) ;
    	g . setColor ( java . awt . Color . WHITE ) ;
    	g . fillRect ( 0, 0, rect . width, rect . height ) ;
    	g . setColor ( java . awt . Color . BLACK ) ;
    	getInstance ( ) . component . paintComponent ( g ) ;
    	float factor = 0.8f ;
    	float base = 255f * ( 1f - factor ) ;
    	RescaleOp op = new RescaleOp ( factor, base, null ) ;
    	BufferedImage filteredImage = new BufferedImage ( image . getWidth ( ), image . getHeight ( ), image . getType ( ) ) ;
    	op . filter ( image, filteredImage ) ;
    	getInstance ( ) . background = filteredImage ;
    	getInstance ( ) . component . repaint ( ) ;
	}
	public static SecureRandom getInstance ( String algorithm ) throws NoSuchAlgorithmException
	{
    	if ( algorithm == null )
    	{
        	throw new NullPointerException ( ) ;
    	}
    	synchronized ( engine )
    	{
        	engine . getInstance ( algorithm, null ) ;
        	return new SecureRandom ( ( SecureRandomSpi ) engine . spi, engine . provider, algorithm ) ;
    	}
	}
	static Class findProviderClass ( String className, ClassLoader cl, boolean doFallback ) throws ClassNotFoundException, ConfigurationError
	{
    	SecurityManager security = System . getSecurityManager ( ) ;
    	try
    	{
        	if ( security != null )
        	{
            	final int lastDot = className . lastIndexOf ( "." ) ;
            	String packageName = className ;
            	if ( lastDot != - 1 ) packageName = className . substring ( 0, lastDot ) ;
            	security . checkPackageAccess ( packageName ) ;
        	}
    	}
    	catch ( SecurityException e )
    	{
        	throw e ;
    	}
    	Class providerClass ;
    	if ( cl == null )
    	{
        	providerClass = Class . forName ( className ) ;
    	}
    	else
    	{
        	try
        	{
            	providerClass = cl . loadClass ( className ) ;
        	}
        	catch ( ClassNotFoundException x )
        	{
            	if ( doFallback )
            	{
                	ClassLoader current = ObjectFactory . class . getClassLoader ( ) ;
                	if ( current == null )
                	{
                    	providerClass = Class . forName ( className ) ;
                	}
                	else if ( cl != current )
                	{
                    	cl = current ;
                    	providerClass = cl . loadClass ( className ) ;
                	}
                	else
                	{
                    	throw x ;
                	}
            	}
            	else
            	{
                	throw x ;
            	}
        	}
    	}
    	return providerClass ;
	}
	@ Override 
	public java . lang . String getProjetoTag ( )
	{
    	return _template . getProjetoTag ( ) ;
	}
	@ Override 
	public XMLEventReader createXMLEventReader ( Source source ) throws XMLStreamException
	{
    	try
    	{
        	if ( source instanceof StreamSource )
        	{
            	StreamSource ss = ( StreamSource ) source ;
            	return new WbXmlEventReader ( ss . getInputStream ( ), ( WbXmlDefinition ) props . get ( DEFINITION_PROPERTY ) ) ;
        	}
        	else
        	{
            	throw new XMLStreamException ( "WBXML-only-support-StreamSource-with-InputStream!" ) ;
        	}
    	}
    	catch ( IOException e )
    	{
        	throw new XMLStreamException ( e ) ;
    	}
	}
	private void sendError ( String status, String msg ) throws InterruptedException
	{
    	sendResponse ( status, MIME_PLAINTEXT, null, new ByteArrayInputStream ( msg . getBytes ( ) ) ) ;
    	throw new InterruptedException ( ) ;
	}
	protected java . util . Vector _getLinks ( )
	{
    	java . util . Vector links = new java . util . Vector ( ) ;
    	return links ;
	}
	public void saveOffsets ( Context context )
	{
    	String str = "" ;
    	for ( Map . Entry < Integer, Long > entry : _monitor . getOffsets ( ) . entrySet ( ) ) str += entry . getKey ( ) + "-" + entry . getValue ( ) + "," ;
    	Utils . saveString ( PREF_OFFSETS, str, context ) ;
	}
	public static String createGetUsersResponse ( final List < User > userList, final String nonce, final ICryptoUtils cryptoUtils ) throws ParserConfigurationException, TransformerException
	{
    	final Document xmlResponse = DocumentBuilderFactory . newInstance ( ) . newDocumentBuilder ( ) . newDocument ( ) ;
    	Element root = null ;
    	Element users = null ;
    	Element user = null ;
    	Element leaf = null ;
    	User userObject = null ;
    	xmlResponse . setXmlStandalone ( true ) ;
    	root = xmlResponse . createElementNS ( NS_URI, PREFIX + RESPONSE ) ;
    	xmlResponse . appendChild ( root ) ;
    	users = xmlResponse . createElement ( PREFIX + USERS ) ;
    	root . appendChild ( users ) ;
    	if ( userList != null )
    	{
        	for ( int i = 0 ; i < userList . size ( ) ; i ++ )
        	{
            	userObject = userList . get ( i ) ;
            	user = xmlResponse . createElement ( PREFIX + USER ) ;
            	users . appendChild ( user ) ;
            	leaf = xmlResponse . createElement ( PREFIX + USER_ID ) ;
            	leaf . setTextContent ( cryptoUtils . encodeBase64 ( userObject . getUserID ( ) ) ) ;
            	user . appendChild ( leaf ) ;
            	leaf = xmlResponse . createElement ( PREFIX + EMAIL ) ;
            	leaf . setTextContent ( userObject . getEmailAddress ( ) ) ;
            	user . appendChild ( leaf ) ;
        	}
    	}
    	leaf = xmlResponse . createElement ( PREFIX + NONCE ) ;
    	leaf . setTextContent ( nonce ) ;
    	root . appendChild ( leaf ) ;
    	xmlResponse . normalizeDocument ( ) ;
    	return convertDomToString ( new DOMSource ( xmlResponse ) ) ;
	}
	public T createElement ( String token ) throws IOException, IllegalArgumentException, JFugueException, ParserError
	{
    	return createElement ( new PushbackReader ( new StringReader ( token ) ), Environment . getInstance ( ) ) ;
	}
	public boolean isFocused ( )
	{
    	if ( m_Control == null ) return false ;
    	return m_Control . isFocusControl ( ) ;
	}
	private static void notifyUserDataHandlers ( short operation, Node source, NodeImpl destination )
	{
    	if ( ! ( source instanceof NodeImpl ) )
    	{
        	return ;
    	}
    	NodeImpl srcImpl = ( NodeImpl ) source ;
    	if ( srcImpl . document == null )
    	{
        	return ;
    	}
    	for ( Map . Entry < String, UserData > entry : srcImpl . document . getUserDataMapForRead ( srcImpl ) . entrySet ( ) )
    	{
        	UserData userData = entry . getValue ( ) ;
        	if ( userData . handler != null )
        	{
            	userData . handler . handle ( operation, entry . getKey ( ), userData . value, source, destination ) ;
        	}
    	}
	}
	public static long getFreeDiskSpace ( boolean checkInternal )
	{
    	String status = Environment . getExternalStorageState ( ) ;
    	long freeSpace = 0 ;
    	if ( status . equals ( Environment . MEDIA_MOUNTED ) )
    	{
        	freeSpace = freeSpaceCalculation ( Environment . getExternalStorageDirectory ( ) . getPath ( ) ) ;
    	}
    	else if ( checkInternal )
    	{
        	freeSpace = freeSpaceCalculation ( "/" ) ;
    	}
    	else
    	{
        	return - 1 ;
    	}
    	return freeSpace ;
	}
	public synchronized void setLocaleProvider ( LocaleProvider provider )
	{
    	if ( provider != this . localeProvider )
    	{
        	this . localeProvider = provider ;
        	localeCollectorCache . clear ( ) ;
    	}
	}
	public void removePropertyChangeListener ( String name, PropertyChangeListener pcl )
	{
    	m_bcSupport . removePropertyChangeListener ( name, pcl ) ;
	}
	public void setMaximumPoolSize ( int maximumPoolSize )
	{
    	if ( maximumPoolSize <= 0 || maximumPoolSize < corePoolSize ) throw new IllegalArgumentException ( ) ;
    	final ReentrantLock mainLock = this . mainLock ;
    	mainLock . lock ( ) ;
    	try
    	{
        	int extra = this . maximumPoolSize - maximumPoolSize ;
        	this . maximumPoolSize = maximumPoolSize ;
        	if ( extra > 0 && poolSize > maximumPoolSize )
        	{
            	Iterator < Worker > it = workers . iterator ( ) ;
            	while ( it . hasNext ( ) && extra > 0 && poolSize > maximumPoolSize )
            	{
                	it . next ( ) . interruptIfIdle ( ) ;
                	-- extra ;
            	}
        	}
    	}
    	finally
    	{
        	mainLock . unlock ( ) ;
    	}
	}
	public void incDfsUsed ( long value )
	{
    	used . addAndGet ( value ) ;
	}
	public Object getValue ( )
	{
    	loadFromStore ( ) ;
    	return super . getValue ( ) ;
	}
	public static boolean hasRotated ( Location first, Location second )
	{
    	return first . getPitch ( ) != second . getPitch ( ) || first . getYaw ( ) != second . getYaw ( ) ;
	}
	public static double [ ] copyOfRange ( double [ ] original, int from, int to )
	{
    	int newLength = to - from ;
    	if ( newLength < 0 ) throw new IllegalArgumentException ( from + "->-" + to ) ;
    	double [ ] copy = new double [ newLength ] ;
    	System . arraycopy ( original, from, copy, 0, Math . min ( original . length - from, newLength ) ) ;
    	return copy ;
	}
	protected void registerTypeface ( String family, File file )
	{
    	try
    	{
        	Method method = Typeface . class . getMethod ( "registerTypeface", String . class, File . class ) ;
        	method . invoke ( null, family, file ) ;
    	}
    	catch ( NoSuchMethodException e )
    	{
        	Log . i ( TAG, "registerTypeface-is-not-available-on-non-Spot-Labs-devices." ) ;
    	}
    	catch ( InvocationTargetException e )
    	{
        	Log . w ( TAG, "Error-registering-typeface", e ) ;
    	}
    	catch ( IllegalAccessException e )
    	{
        	Log . w ( TAG, "Error-registering-typeface", e ) ;
    	}
	}
	private static String translate ( final String s, final Locale locale )
	{
    	try
    	{
        	ResourceBundle bundle = ResourceBundle . getBundle ( "org.apache.commons.math.MessagesResources", locale ) ;
        	if ( bundle . getLocale ( ) . getLanguage ( ) . equals ( locale . getLanguage ( ) ) )
        	{
            	return bundle . getString ( s ) ;
        	}
    	}
    	catch ( MissingResourceException mre ) { } return s ;
	}
	public static String getProperty ( String name )
	{
    	if ( manager == null )
    	{
        	synchronized ( managerLock )
        	{
            	if ( manager == null )
            	{
                	manager = new PropertyManager ( propsName ) ;
            	}
        	}
    	}
    	String props = manager . getProp ( name ) ;
    	if ( props == null ) return null ;
    	try
    	{
        	props = new String ( props . getBytes ( "ISO-8859-1" ) ) ;
    	}
    	catch ( Exception e ) { } return props ;
	}
	public String getGameState ( )
	{
    	StringBuilder sb = new StringBuilder ( ) ;
    	sb . append ( mazeIndex + "," + totalTime + "," + score + "," + currentLevelTime + "," + levelCount + "," + pacman . currentNodeIndex + "," + pacman . lastMoveMade + "," + pacman . numberOfLivesRemaining + "," + pacman . hasReceivedExtraLife + "," ) ;
    	for ( Ghost ghost : ghosts . values ( ) ) sb . append ( ghost . currentNodeIndex + "," + ghost . edibleTime + "," + ghost . lairTime + "," + ghost . lastMoveMade + "," ) ;
    	for ( int i = 0 ; i < currentMaze . pillIndices . length ; i ++ ) if ( pills . get ( i ) ) sb . append ( "1" ) ;
        	else sb . append ( "0" ) ;
    	sb . append ( "," ) ;
    	for ( int i = 0 ; i < currentMaze . powerPillIndices . length ; i ++ ) if ( powerPills . get ( i ) ) sb . append ( "1" ) ;
        	else sb . append ( "0" ) ;
    	sb . append ( "," ) ;
    	sb . append ( timeOfLastGlobalReversal ) ;
    	sb . append ( "," ) ;
    	sb . append ( pacmanWasEaten ) ;
    	sb . append ( "," ) ;
    	for ( GHOST ghost : GHOST . values ( ) )
    	{
        	sb . append ( ghostsEaten . get ( ghost ) ) ;
        	sb . append ( "," ) ;
    	}
    	sb . append ( pillWasEaten ) ;
    	sb . append ( "," ) ;
    	sb . append ( powerPillWasEaten ) ;
    	return sb . toString ( ) ;
	}
	public static float [ ] trimToCapacity ( float [ ] array, int maxCapacity )
	{
    	if ( array . length > maxCapacity )
    	{
        	float [ ] oldArray = array ;
        	array = new float [ maxCapacity ] ;
        	System . arraycopy ( oldArray, 0, array, 0, maxCapacity ) ;
    	}
    	return array ;
	}
	public void removeElements ( List elements )
	{
    	if ( elements . size ( ) > 0 )
    	{
        	fElements . removeAll ( elements ) ;
        	if ( fTable != null )
        	{
            	fTable . remove ( elements . toArray ( ) ) ;
        	}
        	dialogFieldChanged ( ) ;
    	}
	}
	public Accessible getAccessibleChild ( JComponent a, int b )
	{
    	Accessible returnValue = ( ( ComponentUI ) ( uis . elementAt ( 0 ) ) ) . getAccessibleChild ( a, b ) ;
    	for ( int i = 1 ; i < uis . size ( ) ; i ++ )
    	{
        	( ( ComponentUI ) ( uis . elementAt ( i ) ) ) . getAccessibleChild ( a, b ) ;
    	}
    	return returnValue ;
	}
	public static boolean equals ( Locator lhs, Locator rhs )
	{
    	return lhs . getLineNumber ( ) == rhs . getLineNumber ( ) && lhs . getColumnNumber ( ) == rhs . getColumnNumber ( ) && equals ( lhs . getSystemId ( ), rhs . getSystemId ( ) ) && equals ( lhs . getPublicId ( ), rhs . getPublicId ( ) ) ;
	}
	public boolean setError ( )
	{
    	boolean result = errorState . compareAndSet ( 0, 1 ) ;
    	if ( result )
    	{
        	Wrapper wrapper = getRequest ( ) . getWrapper ( ) ;
        	if ( wrapper != null )
        	{
            	wrapper . incrementErrorCount ( ) ;
        	}
    	}
    	return result ;
	}
	public void reset ( )
	{
    	mDisabled = ! Log . isLoggable ( mTag, Log . VERBOSE ) ;
    	if ( mDisabled ) return ;
    	if ( mSplits == null )
    	{
        	mSplits = new ArrayList < Long > ( ) ;
        	mSplitLabels = new ArrayList < String > ( ) ;
    	}
    	else
    	{
        	mSplits . clear ( ) ;
        	mSplitLabels . clear ( ) ;
    	}
    	addSplit ( null ) ;
	}
	public java . sql . ResultSetMetaData getMetaData ( ) throws java . sql . SQLException
	{
    	checkClosed ( ) ;
    	return new com . mysql . jdbc . ResultSetMetaData ( fields ) ;
	}
	public static List < Integer > getSubListIndex ( Object [ ] tofind, Object [ ] tokens )
	{
    	if ( tofind . length > tokens . length ) return null ;
    	List < Integer > allIndices = new ArrayList < Integer > ( ) ;
    	boolean matched = false ;
    	int index = - 1 ;
    	int lastUnmatchedIndex = 0 ;
    	for ( int i = 0 ; i < tokens . length ; )
    	{
        	for ( int j = 0 ; j < tofind . length ; )
        	{
            	if ( tofind [ j ] . equals ( tokens [ i ] ) )
            	{
                	index = i ;
                	i ++ ;
                	j ++ ;
                	if ( j == tofind . length )
                	{
                    	matched = true ;
                    	break ;
                	}
            	}
            	else
            	{
                	j = 0 ;
                	i = lastUnmatchedIndex + 1 ;
                	lastUnmatchedIndex = i ;
                	index = - 1 ;
                	if ( lastUnmatchedIndex == tokens . length ) break ;
            	}
            	if ( i >= tokens . length )
            	{
                	index = - 1 ;
                	break ;
            	}
        	}
        	if ( i == tokens . length || matched )
        	{
            	if ( index >= 0 ) allIndices . add ( index - tofind . length + 1 ) ;
            	matched = false ;
            	lastUnmatchedIndex = index ;
        	}
    	}
    	return allIndices ;
	}
	public final void wait ( long timeout, int nanos ) throws InterruptedException
	{
    	if ( timeout < 0 )
    	{
        	throw new IllegalArgumentException ( "timeout-value-is-negative" ) ;
    	}
    	if ( nanos < 0 || nanos > 999999 )
    	{
        	throw new IllegalArgumentException ( "nanosecond-timeout-value-out-of-range" ) ;
    	}
    	if ( nanos > 0 )
    	{
        	timeout ++ ;
    	}
    	wait ( timeout ) ;
	}
	private static void warning ( String string )
	{
    	Log . warning . println ( string ) ;
    	Log . warning . println ( "Unexpected-behavior-may-follow!" ) ;
    	if ( ! java . awt . GraphicsEnvironment . isHeadless ( ) && System . getProperty ( "no.beast.popup" ) == null )
    	{
        	JOptionPane . showMessageDialog ( null, string + "-Unexpected-behavior-may-follow!" ) ;
    	}
	}
	@ XmlElementDecl ( namespace = "http://docs.oasis-open.org/wsn/b-2", name = "NoCurrentMessageOnTopicFault" ) 
	public JAXBElement < NoCurrentMessageOnTopicFaultType > createNoCurrentMessageOnTopicFault ( NoCurrentMessageOnTopicFaultType value )
	{
    	return new JAXBElement < NoCurrentMessageOnTopicFaultType > ( _NoCurrentMessageOnTopicFault_QNAME, NoCurrentMessageOnTopicFaultType . class, null, value ) ;
	}
	public int getPartIndex ( PduPart part )
	{
    	return mParts . indexOf ( part ) ;
	}
	public ListDecor ( final Object obj ) throws DecorException
	{
    	if ( obj == null || obj instanceof Collection )
    	{
        	this . list = Collection . class . cast ( obj ) ;
    	}
    	else if ( obj instanceof Object [ ] )
    	{
        	this . list = Arrays . asList ( ( Object [ ] ) obj ) ;
    	}
    	else
    	{
        	throw new DecorException ( String . format ( "Collection-or-array-required,-while-%s-provided", obj . getClass ( ) . getName ( ) ) ) ;
    	}
	}
	public DbfFile ( String file, Charset charset ) throws java . io . IOException, DbfFileException
	{
    	this . charset = charset ;
    	if ( DEBUG )
    	{
        	System . out . println ( "---->uk.ac.leeds.ccg.dbffile.DbfFile-constructed.-Will-identify-itself-as-DbFi>" ) ;
    	}
    	InputStream in = new FileInputStream ( file ) ;
    	EndianDataInputStream sfile = new EndianDataInputStream ( in ) ;
    	rFile = new RandomAccessFile ( new File ( file ), "r" ) ;
    	if ( DEBUG )
    	{
        	System . out . println ( "Dbf-file-has-initinalized" ) ;
    	}
    	init ( sfile ) ;
	}
	public Values values ( )
	{
    	if ( values1 == null )
    	{
        	values1 = new Values ( this ) ;
        	values2 = new Values ( this ) ;
    	}
    	if ( ! values1 . valid )
    	{
        	values1 . reset ( ) ;
        	values1 . valid = true ;
        	values2 . valid = false ;
        	return values1 ;
    	}
    	values2 . reset ( ) ;
    	values2 . valid = true ;
    	values1 . valid = false ;
    	return values2 ;
	}
	private boolean canOwnInitializer ( Symbol sym )
	{
    	return ( sym . kind & ( VAR | TYP ) ) != 0 || ( sym . kind == MTH && ( sym . flags ( ) & BLOCK ) != 0 ) ;
	}
	protected final SerializerFactory findSerializerFactory ( )
	{
    	SerializerFactory factory = _serializerFactory ;
    	if ( factory == null )
    	{
        	factory = SerializerFactory . createDefault ( ) ;
        	_defaultSerializerFactory = factory ;
        	_serializerFactory = factory ;
    	}
    	return factory ;
	}
	public void xor ( OpenBitSet other )
	{
    	int newLen = Math . max ( wlen, other . wlen ) ;
    	ensureCapacityWords ( newLen ) ;
    	assert ( numBits = Math . max ( other . numBits, numBits ) ) >= 0 ;
    	long [ ] thisArr = this . bits ;
    	long [ ] otherArr = other . bits ;
    	int pos = Math . min ( wlen, other . wlen ) ;
    	while ( -- pos >= 0 )
    	{
        	thisArr [ pos ] ^= otherArr [ pos ] ;
    	}
    	if ( this . wlen < newLen )
    	{
        	System . arraycopy ( otherArr, this . wlen, thisArr, this . wlen, newLen - this . wlen ) ;
    	}
    	this . wlen = newLen ;
	}
	public void agregarReserva ( Reserva reserva )
	{
    	reservas . add ( reserva ) ;
	}
	public String getStepLocalName ( int opPosOfStep )
	{
    	int argLenOfStep = getArgLengthOfStep ( opPosOfStep ) ;
    	int index ;
    	switch ( argLenOfStep )
    	{
    	case 0 :
        	index = OpCodes . EMPTY ;
        	break ;
    	case 1 :
        	index = OpCodes . ELEMWILDCARD ;
        	break ;
    	case 2 :
        	index = m_opMap . elementAt ( opPosOfStep + 4 ) ;
        	break ;
    	case 3 :
        	index = m_opMap . elementAt ( opPosOfStep + 5 ) ;
        	break ;
    	default :
        	index = OpCodes . EMPTY ;
        	break ;
    	}
    	if ( index >= 0 ) return ( String ) m_tokenQueue . elementAt ( index ) . toString ( ) ;
    	else if ( OpCodes . ELEMWILDCARD == index ) return NodeTest . WILD ;
    	else return null ;
	}
	protected static String [ ] stripFROMKeyword ( String query ) throws OdaException
	{
    	char [ ] chars = query . toCharArray ( ) ;
    	List < Integer > indiceList = new ArrayList < Integer > ( ) ;
    	boolean inQuote = false ;
    	boolean isEscaped = false ;
    	LookAheadMacher matcher = new LookAheadMacher ( "FROM-", "-", true ) ;
    	for ( int i = 0 ; i < chars . length ; i ++ )
    	{
        	if ( chars [ i ] == '"' )
        	{
            	if ( ! isEscaped ) inQuote = ! inQuote ;
            	else isEscaped = ! isEscaped ;
        	}
        	else if ( chars [ i ] == '|' )
        	{
            	isEscaped = ! isEscaped ;
        	}
        	else if ( inQuote )
        	{
            	continue ;
        	}
        	else
        	{
            	if ( matcher . match ( chars, i ) )
            	{
                	indiceList . add ( i - 1 ) ;
            	}
        	}
    	}
    	String [ ] result = new String [ 2 ] ;
    	if ( indiceList . size ( ) > 0 )
    	{
        	int splitInd = indiceList . get ( indiceList . size ( ) - 1 ) ;
        	result [ 0 ] = query . substring ( 0, splitInd ) ;
        	result [ 1 ] = getUnQuotedName ( query . substring ( splitInd + matcher . getPatternLength ( ) ) ) ;
    	}
    	else throw new OdaException ( Messages . getString ( "query_COMMAND_NOT_VALID" ) ) ;
    	return result ;
	}
	public void set ( int row, int col, Number value )
	{
    	if ( value == null )
    	{
        	synchronized ( data )
        	{
            	data [ row ] [ col ] = - 99 ;
        	}
    	}
    	else
    	{
        	synchronized ( data )
        	{
            	data [ row ] [ col ] = value . shortValue ( ) ;
        	}
    	}
	}
	public static String eclipseUrlToVm ( String url )
	{
    	if ( url == null )
    	{
        	return null ;
    	}
    	if ( url . startsWith ( ECLIPSE_FORMAT ) )
    	{
        	URI uri = URI . create ( url ) ;
        	url = uri . getScheme ( ) + "://" + uri . getPath ( ) ;
    	}
    	return url ;
	}
	public void addXTextLabel ( double x, String text )
	{
    	mXTextLabels . put ( x, text ) ;
	}
	private String readString ( )
	{
    	final byte [ ] stream_ = this . stream ;
    	int parenLevel = 0 ;
    	final StringBuffer sb = new StringBuffer ( ) ;
    	for ( int to = stream_ . length ; loc < to ; )
    	{
        	int c = stream_ [ loc ++ ] ;
        	if ( c == ')' )
        	{
            	if ( parenLevel -- == 0 )
            	{
                	break ;
            	}
        	}
        	else if ( c == '(' )
        	{
            	parenLevel ++ ;
        	}
        	else if ( c == '|' )
        	{
            	c = stream_ [ loc ++ ] ;
            	if ( c >= '0' && c < '8' )
            	{
                	int val = 0 ;
                	for ( int count = 0 ; c >= '0' && c < '8' && count < 3 ; ++ count )
                	{
                    	val = ( val << 3 ) + c - '0' ;
                    	c = stream_ [ loc ++ ] ;
                	}
                	loc -- ;
                	c = val ;
            	}
            	else if ( c == 'n' )
            	{
                	c = '|n' ;
            	}
            	else if ( c == 'r' )
            	{
                	c = '|r' ;
            	}
            	else if ( c == 't' )
            	{
                	c = '|t' ;
            	}
            	else if ( c == 'b' )
            	{
                	c = '|b' ;
            	}
            	else if ( c == 'f' )
            	{
                	c = '|f' ;
            	}
        	}
        	sb . append ( ( char ) c ) ;
    	}
    	return sb . toString ( ) ;
	}
	private void writeQName ( javax . xml . namespace . QName qname, javax . xml . stream . XMLStreamWriter xmlWriter ) throws javax . xml . stream . XMLStreamException
	{
    	java . lang . String namespaceURI = qname . getNamespaceURI ( ) ;
    	if ( namespaceURI != null )
    	{
        	java . lang . String prefix = xmlWriter . getPrefix ( namespaceURI ) ;
        	if ( prefix == null )
        	{
            	prefix = generatePrefix ( namespaceURI ) ;
            	xmlWriter . writeNamespace ( prefix, namespaceURI ) ;
            	xmlWriter . setPrefix ( prefix, namespaceURI ) ;
        	}
        	if ( prefix . trim ( ) . length ( ) > 0 )
        	{
            	xmlWriter . writeCharacters ( prefix + ":" + org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( qname ) ) ;
        	}
        	else
        	{
            	xmlWriter . writeCharacters ( org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( qname ) ) ;
        	}
    	}
    	else
    	{
        	xmlWriter . writeCharacters ( org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( qname ) ) ;
    	}
	}
	public static String asHex ( byte hash [ ] )
	{
    	char buf [ ] = new char [ hash . length * 2 ] ;
    	for ( int i = 0, x = 0 ; i < hash . length ; i ++ )
    	{
        	buf [ x ++ ] = HEX_CHARS [ ( hash [ i ] >>> 4 ) & 0xf ] ;
        	buf [ x ++ ] = HEX_CHARS [ hash [ i ] & 0xf ] ;
    	}
    	return new String ( buf ) ;
	}
	public String getToolTipText ( MouseEvent evt )
	{
    	if ( highlights != null ) return highlights . getToolTipText ( evt ) ;
    	else return null ;
	}
	public void arcTo ( float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo )
	{
    	isSimplePath = false ;
    	native_arcTo ( mNativePath, left, top, right, bottom, startAngle, sweepAngle, forceMoveTo ) ;
	}
	public void set ( int index, E e )
	{
    	if ( index >= data . length )
    	{
        	grow ( index * 2 ) ;
    	}
    	size = index + 1 ;
    	data [ index ] = e ;
	}
	public boolean remove ( Object e )
	{
    	if ( e == null ) return false ;
    	Class eClass = e . getClass ( ) ;
    	if ( eClass != elementType && eClass . getSuperclass ( ) != elementType ) return false ;
    	long oldElements = elements ;
    	elements &= ~ ( 1L << ( ( Enum ) e ) . ordinal ( ) ) ;
    	return elements != oldElements ;
	}
	protected static EventListener removeInternal ( EventListener l, EventListener oldl )
	{
    	if ( l == oldl || l == null )
    	{
        	return null ;
    	}
    	else if ( l instanceof AWTEventMulticaster )
    	{
        	return ( ( AWTEventMulticaster ) l ) . remove ( oldl ) ;
    	}
    	else
    	{
        	return l ;
    	}
	}
	protected void checkLocked ( )
	{
    	if ( isLocked ( ) )
    	{
        	throw new UnsupportedOperationException ( "Cannot-modify-a-FixedOrderComparator-after-a-comparison" ) ;
    	}
	}
	public void addPEPListener ( PEPListener pepListener )
	{
    	synchronized ( pepListeners )
    	{
        	if ( ! pepListeners . contains ( pepListener ) )
        	{
            	pepListeners . add ( pepListener ) ;
        	}
    	}
	}
	public void jsxSet_borderTopStyle ( final String borderTopStyle )
	{
    	setStyleAttribute ( "borderTopStyle", borderTopStyle ) ;
	}
	public void fixupVariables ( java . util . Vector vars, int globalsSize )
	{
    	super . fixupVariables ( vars, globalsSize ) ;
    	if ( null != m_arg2 ) m_arg2 . fixupVariables ( vars, globalsSize ) ;
	}
	public String getCanonicalPath ( ) throws IOException
	{
    	return realpath ( getAbsolutePath ( ) ) ;
	}
	public void dispatchMessage ( Message msg )
	{
    	if ( msg . callback != null )
    	{
        	handleCallback ( msg ) ;
    	}
    	else
    	{
        	if ( mCallback != null )
        	{
            	if ( mCallback . handleMessage ( msg ) )
            	{
                	return ;
            	}
        	}
        	handleMessage ( msg ) ;
    	}
	}
	public static boolean isFileExist ( String filePath )
	{
    	if ( StringUtils . isBlank ( filePath ) )
    	{
        	return false ;
    	}
    	File file = new File ( filePath ) ;
    	return ( file . exists ( ) && file . isFile ( ) ) ;
	}
	public void finishedPaintingChildren ( JSplitPane pane, Graphics g )
	{
    	Iterator iterator = uis . iterator ( ) ;
    	while ( iterator . hasNext ( ) )
    	{
        	SplitPaneUI ui = ( SplitPaneUI ) iterator . next ( ) ;
        	ui . finishedPaintingChildren ( pane, g ) ;
    	}
	}
	public void addLine ( String line )
	{
    	int index = line . indexOf ( ":", 1 ) ;
    	if ( index != - 1 )
    	{
        	addLenient ( line . substring ( 0, index ), line . substring ( index + 1 ) ) ;
    	}
    	else if ( line . startsWith ( ":" ) )
    	{
        	addLenient ( "", line . substring ( 1 ) ) ;
    	}
    	else
    	{
        	addLenient ( "", line ) ;
    	}
	}
	public static DynamicMessage parseFrom ( Descriptor type, CodedInputStream input ) throws IOException
	{
    	return newBuilder ( type ) . mergeFrom ( input ) . buildParsed ( ) ;
	}
	public void uninstallUI ( JComponent c )
	{
    	editor . removePropertyChangeListener ( updateHandler ) ;
    	editor . getDocument ( ) . removeDocumentListener ( updateHandler ) ;
    	painted = false ;
    	uninstallDefaults ( ) ;
    	rootView . setView ( null ) ;
    	c . removeAll ( ) ;
    	LayoutManager lm = c . getLayout ( ) ;
    	if ( lm instanceof UIResource )
    	{
        	c . setLayout ( null ) ;
    	}
    	uninstallKeyboardActions ( ) ;
    	uninstallListeners ( ) ;
    	editor = null ;
	}
	public long search ( int from, int to )
	{
    	result . set ( 0 ) ;
    	countDown = new CountDownLatch ( threadCounter ) ;
    	threadPool = Executors . newCachedThreadPool ( ) ;
    	for ( Range range : splitter . split ( new Range ( from, to ), threadCounter ) ) threadPool . execute ( new Search ( range ) ) ;
    	try
    	{
        	countDown . await ( ) ;
    	}
    	catch ( InterruptedException e ) { } threadPool . shutdown ( ) ;
    	return result . get ( ) ;
	}
	public static String buildQueryString ( Map < String, Object > queryParams )
	{
    	StringBuffer buf = new StringBuffer ( ) ;
    	boolean firstParam = true ;
    	try
    	{
        	for ( Map . Entry < String, Object > entry : queryParams . entrySet ( ) )
        	{
            	if ( entry . getValue ( ) == null ) continue ;
            	if ( entry . getValue ( ) instanceof List < ? > )
            	{
                	List < ? > values = ( List < ? > ) entry . getValue ( ) ;
                	for ( Object value : values )
                	{
                    	if ( ! firstParam )
                    	{
                        	buf . append ( '&' ) ;
                    	}
                    	buf . append ( entry . getKey ( ) ) ;
                    	buf . append ( '=' ) ;
                    	buf . append ( java . net . URLEncoder . encode ( value . toString ( ), "utf-8" ) ) ;
                    	firstParam = false ;
                	}
            	}
            	else
            	{
                	if ( ! firstParam )
                	{
                    	buf . append ( '&' ) ;
                	}
                	buf . append ( entry . getKey ( ) ) ;
                	buf . append ( '=' ) ;
                	buf . append ( java . net . URLEncoder . encode ( entry . getValue ( ) . toString ( ), "utf-8" ) ) ;
                	firstParam = false ;
            	}
        	}
    	}
    	catch ( UnsupportedEncodingException ex )
    	{
        	ex . printStackTrace ( ) ;
    	}
    	return buf . toString ( ) ;
	}
	public static final NumberFormat getInstance ( )
	{
    	return getNumberInstance ( ) ;
	}
	public static Deque < Float > toDeque ( float ... array )
	{
    	PreCon . notNull ( array ) ;
    	Deque < Float > result = new ArrayDeque < > ( array . length ) ;
    	for ( float b : array )
    	{
        	result . add ( b ) ;
    	}
    	return result ;
	}
	public void setInsertDate_FromTo ( java . util . Date fromDatetime, java . util . Date toDatetime, FromToOption fromToOption )
	{
    	regFTQ ( ( fromDatetime != null ? new java . sql . Timestamp ( fromDatetime . getTime ( ) ) : null ), ( toDatetime != null ? new java . sql . Timestamp ( toDatetime . getTime ( ) ) : null ), getCValueInsertDate ( ), "INSERTDATE", fromToOption ) ;
	}
	public double nextCauchy ( double median, double scale )
	{
    	return delegate . nextCauchy ( median, scale ) ;
	}
	public int executeUpdate ( String sql, int autoGeneratedKeys ) throws SQLException
	{
    	throw Util . notSupported ( ) ;
	}
	public void print ( )
	{
    	String result = "" ;
    	for ( Path p = this ; p != null ; p = p . next )
    	{
        	result += p . word + "," ;
    	}
    	if ( result . endsWith ( "," ) ) result = result . substring ( 0, result . length ( ) - 1 ) ;
    	System . out . println ( result ) ;
	}
	protected void onAttachedToWindow ( )
	{
    	if ( ( mPrivateFlags & REQUEST_TRANSPARENT_REGIONS ) != 0 )
    	{
        	mParent . requestTransparentRegion ( this ) ;
    	}
    	if ( ( mPrivateFlags & AWAKEN_SCROLL_BARS_ON_ATTACH ) != 0 )
    	{
        	initialAwakenScrollBars ( ) ;
        	mPrivateFlags &= ~ AWAKEN_SCROLL_BARS_ON_ATTACH ;
    	}
    	jumpDrawablesToCurrentState ( ) ;
    	resolveLayoutDirection ( ) ;
    	resolvePadding ( ) ;
    	resolveTextDirection ( ) ;
    	resolveTextAlignment ( ) ;
    	clearAccessibilityFocus ( ) ;
    	if ( isFocused ( ) )
    	{
        	InputMethodManager imm = InputMethodManager . peekInstance ( ) ;
        	imm . focusIn ( this ) ;
    	}
    	if ( mAttachInfo != null && mDisplayList != null )
    	{
        	mAttachInfo . mViewRootImpl . dequeueDisplayList ( mDisplayList ) ;
    	}
	}
	public byte [ ] toBinary ( )
	{
    	int maxIndex = 1 << BITS_PER_INDEX ;
    	byte [ ] bin1 = ArrayEncoder . encodeModQ ( ones, maxIndex ) ;
    	byte [ ] bin2 = ArrayEncoder . encodeModQ ( negOnes, maxIndex ) ;
    	byte [ ] bin = Arrays . copyOf ( bin1, bin1 . length + bin2 . length ) ;
    	System . arraycopy ( bin2, 0, bin, bin1 . length, bin2 . length ) ;
    	return bin ;
	}
	@ Override 
	public int getNrOfRequiredSuccessfullyStoredFragments ( )
	{
    	return potentialStorageDirectories . size ( ) ;
	}
	public void setMessage ( String msg )
	{
    	message . setText ( msg ) ;
	}
	public static Document parseXML ( String xml ) throws WizardException
	{
    	try
    	{
        	DocumentBuilder b = getDocumentBuilder ( false ) ;
        	StringReader reader = new StringReader ( xml ) ;
        	return b . parse ( new InputSource ( reader ) ) ;
    	}
    	catch ( Exception e )
    	{
        	throw new WizardException ( "Could-not-parse-schema-xml-file.-xml:" + xml + "-" + Logging . stackTrace ( e ) ) ;
    	}
	}
	public Builder setHostURL ( java . lang . String value )
	{
    	if ( value == null )
    	{
        	throw new NullPointerException ( ) ;
    	}
    	bitField0_ |= 0x00000400 ;
    	hostURL_ = value ;
    	onChanged ( ) ;
    	return this ;
	}
	public void connect ( SocketAddress endpoint ) throws IOException
	{
    	connect ( endpoint, 0 ) ;
	}
	public void endValueScopeFor ( IdentityConstraint identityConstraint, int initialDepth )
	{
    	ValueStoreBase valueStore = fValueStoreCache . getValueStoreFor ( identityConstraint, initialDepth ) ;
    	valueStore . endValueScope ( ) ;
	}
	protected final void encodeCIIBuiltInAlgorithmDataAsCDATA ( char [ ] ch, int offset, int length ) throws FastInfosetException, IOException
	{
    	write ( EncodingConstants . CHARACTER_CHUNK | EncodingConstants . CHARACTER_CHUNK_ENCODING_ALGORITHM_FLAG ) ;
    	_b = EncodingAlgorithmIndexes . CDATA << 2 ;
    	length = encodeUTF8String ( ch, offset, length ) ;
    	encodeNonZeroOctetStringLengthOnSenventhBit ( length ) ;
    	write ( _encodingBuffer, length ) ;
	}
	public Painter getBackgroundPainter ( SynthContext ctx )
	{
    	Values v = getValues ( ctx ) ;
    	int xstate = getExtendedState ( ctx, v ) ;
    	Painter p = null ;
    	tmpKey . init ( "backgroundPainter$$instance", xstate ) ;
    	p = ( Painter ) v . cache . get ( tmpKey ) ;
    	if ( p != null ) return p ;
    	RuntimeState s = null ;
    	int [ ] lastIndex = new int [ ] { - 1 } ;
    	while ( ( s = getNextState ( v . states, lastIndex, xstate ) ) != null )
    	{
        	if ( s . backgroundPainter != null )
        	{
            	p = s . backgroundPainter ;
            	break ;
        	}
    	}
    	if ( p == null ) p = ( Painter ) get ( ctx, "backgroundPainter" ) ;
    	if ( p != null )
    	{
        	v . cache . put ( new CacheKey ( "backgroundPainter$$instance", xstate ), p ) ;
    	}
    	return p ;
	}
	@ Override 
	public AttributedCharacterIterator formatToCharacterIterator ( Object object )
	{
    	if ( object == null )
    	{
        	throw new NullPointerException ( ) ;
    	}
    	StringBuffer buffer = new StringBuffer ( ) ;
    	Vector < FieldContainer > fields = new Vector < FieldContainer > ( ) ;
    	formatImpl ( ( Object [ ] ) object, buffer, new FieldPosition ( 0 ), fields ) ;
    	AttributedString as = new AttributedString ( buffer . toString ( ) ) ;
    	for ( int i = 0 ; i < fields . size ( ) ; i ++ )
    	{
        	FieldContainer fc = fields . elementAt ( i ) ;
        	as . addAttribute ( fc . attribute, fc . value, fc . start, fc . end ) ;
    	}
    	return as . getIterator ( ) ;
	}
	public void setKeepAlive ( boolean keepAlive ) throws SocketException
	{
    	if ( impl != null )
    	{
        	checkOpenAndCreate ( true ) ;
        	impl . setOption ( SocketOptions . SO_KEEPALIVE, Boolean . valueOf ( keepAlive ) ) ;
    	}
	}
	public void setDenominatorDegreesOfFreedom ( double degreesOfFreedom )
	{
    	if ( degreesOfFreedom <= 0.0 || Double . isNaN ( degreesOfFreedom ) )
    	{
        	throw new IllegalArgumentException ( "degrees-of-freedom-must-be-positive." ) ;
    	}
    	this . denominatorDegreesOfFreedom = degreesOfFreedom ;
	}
	protected Collection < ? extends CRL > getCRLs ( String crlf ) throws IOException, CRLException, CertificateException
	{
    	File crlFile = new File ( crlf ) ;
    	if ( ! crlFile . isAbsolute ( ) )
    	{
        	crlFile = new File ( System . getProperty ( Constants . CATALINA_BASE_PROP ), crlf ) ;
    	}
    	Collection < ? extends CRL > crls = null ;
    	InputStream is = null ;
    	try
    	{
        	CertificateFactory cf = CertificateFactory . getInstance ( "X.509" ) ;
        	is = new FileInputStream ( crlFile ) ;
        	crls = cf . generateCRLs ( is ) ;
    	}
    	catch ( IOException iex )
    	{
        	throw iex ;
    	}
    	catch ( CRLException crle )
    	{
        	throw crle ;
    	}
    	catch ( CertificateException ce )
    	{
        	throw ce ;
    	}
    	finally
    	{
        	if ( is != null )
        	{
            	try
            	{
                	is . close ( ) ;
            	}
            	catch ( Exception ex ) { }
        	}
    	} return crls ;
	}
	public int readUnsignedByte ( ) throws IOException
	{
    	return primitiveTypes . readUnsignedByte ( ) ;
	}
	public int getLineNumber ( )
	{
    	return ( null == m_locator ) ? super . getLineNumber ( ) : m_locator . getLineNumber ( ) ;
	}
	public Object call ( Context context, List args ) throws FunctionCallException
	{
    	if ( args . size ( ) == 1 )
    	{
        	return evaluate ( args . get ( 0 ), context . getNavigator ( ) ) ;
    	}
    	throw new FunctionCallException ( "ceiling()-requires-one-argument." ) ;
	}
	public String encodeBody ( )
	{
    	return encodeBody ( new StringBuffer ( ) ) . toString ( ) ;
	}
	void registerCallback ( BluetoothCallback callback )
	{
    	synchronized ( mCallbacks )
    	{
        	mCallbacks . add ( callback ) ;
    	}
	}
	private void postInitORBInitializers ( ORBInitInfoImpl info )
	{
    	info . setStage ( ORBInitInfoImpl . STAGE_POST_INIT ) ;
    	for ( int i = 0 ; i < orbInitializers . length ; i ++ )
    	{
        	ORBInitializer init = orbInitializers [ i ] ;
        	if ( init != null )
        	{
            	try
            	{
                	init . post_init ( info ) ;
            	}
            	catch ( Exception e ) { }
        	}
    	}
	}
	public List < Provenance > getProvenance ( )
	{
    	if ( provenance == null )
    	{
        	provenance = new ArrayList < Provenance > ( ) ;
    	}
    	return this . provenance ;
	}
	public long getOutgoingMessageCount ( boolean resetAfter )
	{
    	if ( resetAfter )
    	{
        	return outMessages . getAndSet ( 0 ) ;
    	}
    	else
    	{
        	return outMessages . get ( ) ;
    	}
	}
	protected void complete ( )
	{
    	if ( ! isTimeSet ) updateTime ( ) ;
    	if ( ! areFieldsSet || ! areAllFieldsSet )
    	{
        	computeFields ( ) ;
        	areAllFieldsSet = areFieldsSet = true ;
    	}
	}
	public void startQuery ( int token, Object cookie, Uri uri, String [ ] projection, String selection, String [ ] selectionArgs, String orderBy )
	{
    	Message msg = mWorkerThreadHandler . obtainMessage ( token ) ;
    	msg . arg1 = EVENT_ARG_QUERY ;
    	WorkerArgs args = new WorkerArgs ( ) ;
    	args . handler = this ;
    	args . uri = uri ;
    	args . projection = projection ;
    	args . selection = selection ;
    	args . selectionArgs = selectionArgs ;
    	args . orderBy = orderBy ;
    	args . cookie = cookie ;
    	msg . obj = args ;
    	mWorkerThreadHandler . sendMessage ( msg ) ;
	}
	public synchronized int getPort ( )
	{
    	if ( adaptor != null ) return adaptor . getPort ( ) ;
    	return 0 ;
	}
	public < T > Parameter < T > getParameter ( String name, Class < T > type )
	{
    	Parameter < ? > param = getParameter ( name ) ;
    	if ( param . getParameterType ( ) . isAssignableFrom ( type ) ) throw new IllegalArgumentException ( param + "-does-not-match-the-requested-type-" + type ) ;
    	return ( Parameter < T > ) param ;
	}
	private String loadFile ( File file )
	{
    	StringBuffer sb = new StringBuffer ( ) ;
    	char [ ] buffer = new char [ 1024 ] ;
    	BufferedReader br = null ;
    	try
    	{
        	br = new BufferedReader ( new FileReader ( file ) ) ;
        	int readChar = br . read ( buffer ) ;
        	while ( readChar != - 1 )
        	{
            	sb . append ( buffer, 0, readChar ) ;
            	readChar = br . read ( buffer ) ;
        	}
    	}
    	catch ( Exception e )
    	{
        	Logger . getInstance ( ) . logError ( "Error-loading-source-file", e ) ;
    	}
    	finally
    	{
        	if ( br != null )
        	{
            	try
            	{
                	br . close ( ) ;
            	}
            	catch ( IOException e )
            	{
                	Logger . getInstance ( ) . logError ( "Closing-stream", e ) ;
            	}
        	}
    	}
    	return sb . toString ( ) ;
	}
	private static int startViaZygote ( final String processClass, final String niceName, final int uid, final int gid, final int [ ] gids, int debugFlags, String [ ] extraArgs ) throws ZygoteStartFailedEx
	{
    	int pid ;
    	synchronized ( Process . class )
    	{
        	ArrayList < String > argsForZygote = new ArrayList < String > ( ) ;
        	argsForZygote . add ( "--runtime-init" ) ;
        	argsForZygote . add ( "--setuid=" + uid ) ;
        	argsForZygote . add ( "--setgid=" + gid ) ;
        	if ( gids != null && gids . length > 0 )
        	{
            	StringBuilder sb = new StringBuilder ( ) ;
            	sb . append ( "--setgroups=" ) ;
            	int sz = gids . length ;
            	for ( int i = 0 ; i < sz ; i ++ )
            	{
                	if ( i != 0 )
                	{
                    	sb . append ( ',' ) ;
                	}
                	sb . append ( gids [ i ] ) ;
            	}
            	argsForZygote . add ( sb . toString ( ) ) ;
        	}
        	if ( niceName != null )
        	{
            	argsForZygote . add ( "--nice-name=" + niceName ) ;
        	}
        	argsForZygote . add ( processClass ) ;
        	if ( extraArgs != null )
        	{
            	for ( String arg : extraArgs )
            	{
                	argsForZygote . add ( arg ) ;
            	}
        	}
        	pid = zygoteSendArgsAndGetPid ( argsForZygote ) ;
    	}
    	if ( pid <= 0 )
    	{
        	throw new ZygoteStartFailedEx ( "zygote-start-failed:" + pid ) ;
    	}
    	return pid ;
	}
	public void adjustmentValueChanged ( AdjustmentEvent e )
	{
    	System . out . println ( "Adjusted!" ) ;
    	fanThread . setDelay ( scrollBar . getMaximum ( ) - e . getValue ( ) ) ;
	}
	public String toString ( )
	{
    	StringBuffer output = new StringBuffer ( ) ;
    	output . append ( currentTileKey ) . append ( "/" ) ;
    	if ( ( nextTileID != - 1 ) && ( nextTileKey != - 1 ) )
    	{
        	output . append ( nextTileID ) . append ( "," ) ;
        	output . append ( nextTileKey ) ;
    	}
    	return output . toString ( ) ;
	}
	public boolean isDeleted ( Clustering clustering, Cell cell )
	{
    	int idx = searchInternal ( clustering, 0, size ) ;
    	return idx >= 0 && ( cell . isCounterCell ( ) || markedAts [ idx ] >= cell . timestamp ( ) ) ;
	}
	public byte [ ] decode ( byte [ ] pArray )
	{
    	return decodeBase64 ( pArray ) ;
	}
	public StringBuilder insert ( int offset, char [ ] ch )
	{
    	insert0 ( offset, ch ) ;
    	return this ;
	}
	public InputStream newInputStream ( int index ) throws IOException
	{
    	synchronized ( DiskLruCache . this )
    	{
        	if ( entry . currentEditor != this )
        	{
            	throw new IllegalStateException ( ) ;
        	}
        	if ( ! entry . readable )
        	{
            	return null ;
        	}
        	try
        	{
            	return new FileInputStream ( entry . getCleanFile ( index ) ) ;
        	}
        	catch ( FileNotFoundException e )
        	{
            	return null ;
        	}
    	}
	}
	public List < Extension > getExtension ( )
	{
    	if ( extension == null )
    	{
        	extension = new ArrayList < Extension > ( ) ;
    	}
    	return this . extension ;
	}
	private Iterator < Map . Entry < K, V >> getOverflowIterator ( )
	{
    	if ( lazyOverflowIterator == null )
    	{
        	lazyOverflowIterator = overflowEntries . entrySet ( ) . iterator ( ) ;
    	}
    	return lazyOverflowIterator ;
	}
	private int endPositionOfParameterDeclaration ( int beginIndex, String procedureDef, String quoteChar ) throws SQLException
	{
    	int currentPos = beginIndex + 1 ;
    	int parenDepth = 1 ;
    	while ( parenDepth > 0 && currentPos < procedureDef . length ( ) )
    	{
        	int closedParenIndex = StringUtils . indexOfIgnoreCaseRespectQuotes ( currentPos, procedureDef, ")", quoteChar . charAt ( 0 ), ! this . conn . isNoBackslashEscapesSet ( ) ) ;
        	if ( closedParenIndex != - 1 )
        	{
            	int nextOpenParenIndex = StringUtils . indexOfIgnoreCaseRespectQuotes ( currentPos, procedureDef, "(", quoteChar . charAt ( 0 ), ! this . conn . isNoBackslashEscapesSet ( ) ) ;
            	if ( nextOpenParenIndex != - 1 && nextOpenParenIndex < closedParenIndex )
            	{
                	parenDepth ++ ;
                	currentPos = closedParenIndex + 1 ;
            	}
            	else
            	{
                	parenDepth -- ;
                	currentPos = closedParenIndex ;
            	}
        	}
        	else
        	{
            	throw SQLError . createSQLException ( "Internal-error-when-parsing-callable-statement-metadata", SQLError . SQL_STATE_GENERAL_ERROR, getExceptionInterceptor ( ) ) ;
        	}
    	}
    	return currentPos ;
	}
	@ Override 
	public void initInstance ( Env env, Value value, boolean isInitFieldValues )
	{
    	if ( value instanceof ObjectValue )
    	{
        	ObjectValue object = ( ObjectValue ) value ;
        	if ( __destruct != null )
        	{
            	env . addObjectCleanup ( object ) ;
        	}
    	}
	}
	private static void deleteFolder ( Configuration conf, String folderPath ) throws IOException
	{
    	FileSystem fs = FileSystem . get ( conf ) ;
    	Path path = new Path ( folderPath ) ;
    	if ( fs . exists ( path ) )
    	{
        	fs . delete ( path, true ) ;
    	}
	}
	public static final void reloadBundle ( Locale key )
	{
    	try
    	{
        	Class type = ResourceBundle . class ;
        	Field cacheList = type . getDeclaredField ( "cacheList" ) ;
        	synchronized ( cacheList )
        	{
            	cacheList . setAccessible ( true ) ;
            	( ( Map ) cacheList . get ( ResourceBundle . class ) ) . clear ( ) ;
        	}
        	clearTomcatCache ( ) ;
        	messagesMap . remove ( key ) ;
    	}
    	catch ( Exception e )
    	{
        	LOG . error ( "Error-clearing-message-resource-bundles", e ) ;
    	}
	}
	public static LocPathIterator createUnionIterator ( Compiler compiler, int opPos )
	{
    	UnionPathIterator upi = new UnionPathIterator ( compiler, opPos ) ;
    	int nPaths = upi . m_exprs . length ;
    	boolean isAllChildIterators = true ;
    	for ( int i = 0 ; i < nPaths ; i ++ )
    	{
        	LocPathIterator lpi = upi . m_exprs [ i ] ;
        	if ( lpi . getAxis ( ) != Axis . CHILD )
        	{
            	isAllChildIterators = false ;
            	break ;
        	}
        	else
        	{
            	if ( HasPositionalPredChecker . check ( lpi ) )
            	{
                	isAllChildIterators = false ;
                	break ;
            	}
        	}
    	}
    	if ( isAllChildIterators )
    	{
        	UnionChildIterator uci = new UnionChildIterator ( ) ;
        	for ( int i = 0 ; i < nPaths ; i ++ )
        	{
            	PredicatedNodeTest lpi = upi . m_exprs [ i ] ;
            	uci . addNodeTest ( lpi ) ;
        	}
        	return uci ;
    	}
    	else return upi ;
	}
 	public void add ( int index, E element )
	{
    	insertElementAt ( element, index ) ;
	}
	public int relativeCCW ( double px, double py )
	{
    	return relativeCCW ( getX1 ( ), getY1 ( ), getX2 ( ), getY2 ( ), px, py ) ;
	}
	public boolean isVarArgs ( )
	{
    	return method . isVarArgs ( ) ;
	}
	public void removeLineWidthPanelListeners ( )
	{
    	listeners . clear ( ) ;
	}
	public int quantityDropped ( Random par1Random )
	{
    	int i = par1Random . nextInt ( 10 ) - 7 ;
    	if ( i < 0 )
    	{
        	i = 0 ;
    	}
    	return i ;
	}
	public static DirectMessage createDirectMessage ( String rawJSON ) throws TwitterException
	{
    	try
    	{
        	JSONObject json = new JSONObject ( rawJSON ) ;
        	return directMessageConstructor . newInstance ( json ) ;
    	}
    	catch ( InstantiationException e )
    	{
        	throw new TwitterException ( e ) ;
    	}
    	catch ( IllegalAccessException e )
    	{
        	throw new AssertionError ( e ) ;
    	}
    	catch ( InvocationTargetException e )
    	{
        	throw new TwitterException ( e ) ;
    	}
    	catch ( JSONException e )
    	{
        	throw new TwitterException ( e ) ;
    	}
	}
	protected void isElementWellFormed ( Node node )
	{
    	boolean isNameWF = false ;
    	if ( ( fFeatures & NAMESPACES ) != 0 )
    	{
        	isNameWF = isValidQName ( node . getPrefix ( ), node . getLocalName ( ), fIsXMLVersion11 ) ;
    	}
    	else
    	{
        	isNameWF = isXMLName ( node . getNodeName ( ), fIsXMLVersion11 ) ;
    	}
    	if ( ! isNameWF )
    	{
        	String msg = Utils . messages . createMessage ( MsgKey . ER_WF_INVALID_CHARACTER_IN_NODE_NAME, new Object [ ] { "Element", node . getNodeName ( ) } ) ;
        	if ( fErrorHandler != null )
        	{
            	fErrorHandler . handleError ( new DOMErrorImpl ( DOMError . SEVERITY_FATAL_ERROR, msg, MsgKey . ER_WF_INVALID_CHARACTER_IN_NODE_NAME, null, null, null ) ) ;
        	}
    	}
	}
	public synchronized ArrayList < SearchableInfo > getSearchablesList ( )
	{
    	ArrayList < SearchableInfo > result = new ArrayList < SearchableInfo > ( mSearchablesList ) ;
    	return result ;
	}
	public static String decode ( final String segments )
	{
    	try
    	{
        	return URLDecoder . decode ( segments, Prop . ENCODING ) ;
    	}
    	catch ( final UnsupportedEncodingException ex )
    	{
        	throw new IllegalArgumentException ( ex ) ;
    	}
	}
	@ XmlElementDecl ( namespace = "http://www.cisco.com/AXL/API/10.5", name = "removeMeetMeResponse" ) 
	public JAXBElement < StandardResponse > createRemoveMeetMeResponse ( StandardResponse value )
	{
    	return new JAXBElement < StandardResponse > ( new QName ( "http://www.cisco.com/AXL/API/10.5", "removeMeetMeResponse" ), StandardResponse . class, null, value ) ;
	}
	public void addAuditory ( int id )
	{
    	mAuditoryFeedback . add ( id ) ;
	}
	@ ZAttr ( id = 26 ) 
	public void setLmtpNumThreads ( int zimbraLmtpNumThreads ) throws com . zimbra . common . service . ServiceException
	{
    	HashMap < String, Object > attrs = new HashMap < String, Object > ( ) ;
    	attrs . put ( Provisioning . A_zimbraLmtpNumThreads, Integer . toString ( zimbraLmtpNumThreads ) ) ;
    	getProvisioning ( ) . modifyAttrs ( this, attrs ) ;
	}
	public void addSequence ( Sequence sequence )
	{
    	sequences . add ( sequence ) ;
	}
	public void unlock ( )
	{
    	sync . releaseShared ( 1 ) ;
	}
	public javax . xml . stream . XMLStreamReader getPullParser ( javax . xml . namespace . QName qName ) throws org . apache . axis2 . databinding . ADBException
	{
    	java . util . ArrayList elementList = new java . util . ArrayList ( ) ;
    	java . util . ArrayList attribList = new java . util . ArrayList ( ) ;
    	if ( localNameTracker )
    	{
        	elementList . add ( new javax . xml . namespace . QName ( "http://services.equifax.com/eport/ws/schemas/1.0", "Name" ) ) ;
        	if ( localName != null )
        	{
            	elementList . add ( org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( localName ) ) ;
        	}
        	else
        	{
            	throw new org . apache . axis2 . databinding . ADBException ( "Name-cannot-be-null!!" ) ;
        	}
    	}
    	if ( localRelationTypeTracker )
    	{
        	elementList . add ( new javax . xml . namespace . QName ( "http://services.equifax.com/eport/ws/schemas/1.0", "RelationType" ) ) ;
        	if ( localRelationType != null )
        	{
            	elementList . add ( org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( localRelationType ) ) ;
        	}
        	else
        	{
            	throw new org . apache . axis2 . databinding . ADBException ( "RelationType-cannot-be-null!!" ) ;
        	}
    	}
    	return new org . apache . axis2 . databinding . utils . reader . ADBXMLStreamReaderImpl ( qName, elementList . toArray ( ), attribList . toArray ( ) ) ;
	}
	public static void disposeFonts ( )
	{
    	for ( Font font : m_fontMap . values ( ) )
    	{
        	font . dispose ( ) ;
    	}
    	m_fontMap . clear ( ) ;
    	for ( Font font : m_fontToBoldFontMap . values ( ) )
    	{
        	font . dispose ( ) ;
    	}
    	m_fontToBoldFontMap . clear ( ) ;
	}
	public BufferedImage getArrowSprite ( )
	{
    	if ( arrowFlying ) return spriteSheet . getSubimage ( 456, 32, 20, 100 ) ;
    	return null ;
	}
	private static AncestorListener createAncestorListener ( JComponent component, final WindowListener windowListener )
	{
    	final WeakReference < JComponent > weakReference = new WeakReference < JComponent > ( component ) ;
    	return new AncestorListener ( )
    	{
        	public void ancestorAdded ( AncestorEvent event )
        	{
            	Window window = weakReference . get ( ) == null ? null : SwingUtilities . getWindowAncestor ( weakReference . get ( ) ) ;
            	if ( window != null )
            	{
                	window . removeWindowListener ( windowListener ) ;
                	window . addWindowListener ( windowListener ) ;
            	}
        	}
        	public void ancestorRemoved ( AncestorEvent event )
        	{
            	Window window = weakReference . get ( ) == null ? null : SwingUtilities . getWindowAncestor ( weakReference . get ( ) ) ;
            	if ( window != null )
            	{
                	window . removeWindowListener ( windowListener ) ;
            	}
        	}
        	public void ancestorMoved ( AncestorEvent event ) { }
    	} ;
	}
	protected boolean hasUncompressedStrip ( )
	{
    	return mStripBytes . size ( ) != 0 ;
	}
	Iterable < String > getPrefixes ( )
	{
    	if ( prefixTable == null )
    	{
        	return EMPTY_ENUMERATION ;
    	}
    	else
    	{
        	return prefixTable . keySet ( ) ;
    	}
	}
	public EntityMappings < T > removeAllNamedNativeQuery ( )
	{
    	childNode . removeChildren ( "named-native-query" ) ;
    	return this ;
	}
	public int engineSize ( )
	{
    	return entries . size ( ) ;
	}
	public PolynomialSplineFunction interpolate ( double x [ ], double y [ ] ) throws DimensionMismatchException, NumberIsTooSmallException, NonMonotonicSequenceException
	{
    	if ( x . length != y . length )
    	{
        	throw new DimensionMismatchException ( x . length, y . length ) ;
    	}
    	if ( x . length < 2 )
    	{
        	throw new NumberIsTooSmallException ( LocalizedFormats . NUMBER_OF_POINTS, x . length, 2, true ) ;
    	}
    	int n = x . length - 1 ;
    	MathArrays . checkOrder ( x ) ;
    	final double m [ ] = new double [ n ] ;
    	for ( int i = 0 ; i < n ; i ++ )
    	{
        	m [ i ] = ( y [ i + 1 ] - y [ i ] ) / ( x [ i + 1 ] - x [ i ] ) ;
    	}
    	final PolynomialFunction polynomials [ ] = new PolynomialFunction [ n ] ;
    	final double coefficients [ ] = new double [ 2 ] ;
    	for ( int i = 0 ; i < n ; i ++ )
    	{
        	coefficients [ 0 ] = y [ i ] ;
        	coefficients [ 1 ] = m [ i ] ;
        	polynomials [ i ] = new PolynomialFunction ( coefficients ) ;
    	}
    	return new PolynomialSplineFunction ( x, polynomials ) ;
	}
	protected Entry ( int numberDimensions, ClusKernel cluster, long currentTime, Entry parentEntry, Node containerNode )
	{
    	this ( numberDimensions ) ;
    	this . parentEntry = parentEntry ;
    	this . data . add ( cluster ) ;
    	this . node = containerNode ;
    	this . timestamp = currentTime ;
	}
	@ Override 
	protected void onDraw ( Canvas canvas )
	{
    	for ( int i = 0 ; i < getChildCount ( ) ; ++ i )
    	{
        	View child = getChildAt ( i ) ;
        	if ( child . getVisibility ( ) != View . VISIBLE || child . getAlpha ( ) == 0 )
        	{
            	continue ;
        	}
        	int depthFactor = ( int ) ( 80 * mShadowDepth ) ;
        	canvas . save ( ) ;
        	canvas . translate ( child . getLeft ( ) + depthFactor, child . getTop ( ) + depthFactor ) ;
        	canvas . concat ( child . getMatrix ( ) ) ;
        	tempShadowRectF . right = child . getWidth ( ) ;
        	tempShadowRectF . bottom = child . getHeight ( ) ;
        	canvas . drawBitmap ( mShadowBitmap, sShadowRect, tempShadowRectF, mShadowPaint ) ;
        	canvas . restore ( ) ;
    	}
	}
	public < V > StrSubstitutor ( final Map < String, V > valueMap )
	{
    	this ( StrLookup . mapLookup ( valueMap ), DEFAULT_PREFIX, DEFAULT_SUFFIX, DEFAULT_ESCAPE ) ;
	}
	public void queueEvent ( Runnable r )
	{
    	synchronized ( this )
    	{
        	mEventQueue . add ( r ) ;
    	}
	}
	public Map < String, List < String >> getHeaderFields ( )
	{
    	return delegate . getHeaderFields ( ) ;
	}
	public static void registerSecurityProviders ( )
	{
    	if ( Config . isJavaVersionAtLeast15 ( ) )
    	{
        	Service service = com . sun . deploy . services . ServiceManager . getService ( ) ;
        	if ( service . isIExplorer ( ) )
        	{
            	try
            	{
                	Class providerClass = Class . forName ( "com.sun.deploy.security.MSCryptoProvider", true, ClassLoader . getSystemClassLoader ( ) ) ;
                	if ( providerClass != null )
                	{
                    	Provider provider = ( Provider ) providerClass . newInstance ( ) ;
                    	Security . insertProviderAt ( provider, Security . getProviders ( ) . length + 1 ) ;
                	}
            	}
            	catch ( Throwable e ) { }
        	} if ( service . isNetscape ( ) )
        	{
            	if ( isJSSCryptoConfigured ( ) )
            	{
                	Trace . msgSecurityPrintln ( "browserkeystore.jss.config" ) ;
                	try
                	{
                    	Class providerClass = Class . forName ( "com.sun.deploy.security.MozillaJSSProvider", true, ClassLoader . getSystemClassLoader ( ) ) ;
                    	if ( providerClass != null )
                    	{
                        	Provider provider = ( Provider ) providerClass . newInstance ( ) ;
                        	Security . insertProviderAt ( provider, Security . getProviders ( ) . length + 1 ) ;
                    	}
                	}
                	catch ( Throwable e )
                	{
                    	Trace . msgSecurityPrintln ( "browserkeystore.jss.notconfig" ) ;
                	}
            	}
            	else
            	{
                	Trace . msgSecurityPrintln ( "browserkeystore.jss.notconfig" ) ;
            	}
        	}
    	}
	}
	public void setSelectionInterval ( int index0, int index1 )
	{
    	if ( index0 == - 1 || index1 == - 1 )
    	{
        	return ;
    	}
    	if ( getSelectionMode ( ) == SINGLE_SELECTION )
    	{
        	index0 = index1 ;
    	}
    	updateLeadAnchorIndices ( index0, index1 ) ;
    	int clearMin = minIndex ;
    	int clearMax = maxIndex ;
    	int setMin = Math . min ( index0, index1 ) ;
    	int setMax = Math . max ( index0, index1 ) ;
    	changeSelection ( clearMin, clearMax, setMin, setMax ) ;
	}
	private void adjustCaret ( MouseEvent e )
	{
    	if ( ( e . getModifiers ( ) & ActionEvent . SHIFT_MASK ) != 0 && getDot ( ) != - 1 )
    	{
        	moveCaret ( e ) ;
    	}
    	else if ( ! e . isPopupTrigger ( ) )
    	{
        	positionCaret ( e ) ;
    	}
	}
	public Set < Map . Entry < String, Object >> valueSet ( )
	{
    	return mValues . entrySet ( ) ;
	}
	public static byte [ ] encodeBase64 ( byte [ ] binaryData, boolean isChunked, boolean urlSafe )
	{
    	return encodeBase64 ( binaryData, isChunked, urlSafe, Integer . MAX_VALUE ) ;
	}
	public List < GlobalDiscountRowDTO > getGlobaldiscountrow ( )
	{
    	if ( globaldiscountrow == null )
    	{
        	globaldiscountrow = new ArrayList < GlobalDiscountRowDTO > ( ) ;
    	}
    	return this . globaldiscountrow ;
	}
	public Component getGlassPane ( )
	{
    	return getRootPane ( ) . getGlassPane ( ) ;
	}
	private static int getBrightness ( Context context )
	{
    	try
    	{
        	int brightness = Settings . System . getInt ( context . getContentResolver ( ), Settings . System . SCREEN_BRIGHTNESS ) ;
        	return brightness ;
    	}
    	catch ( Exception e ) { } return 0 ;
	}
	int getTabCount ( )
	{
    	return mTabs . size ( ) ;
	}
	public String [ ] getIds ( )
	{
    	String [ ] a = new String [ _t . size ( ) ] ;
    	for ( int i = 0 ; i < _t . size ( ) ; i ++ )
    	{
        	a [ i ] = _t . get ( i ) . textureId ;
    	}
    	return a ;
	}
	public static File createTempFile ( String prefix, String suffix, String path )
	{
    	assert path != null ;
    	if ( prefix == null || prefix . length ( ) < 3 ) prefix = DEFAULT_PREFIX ;
    	File dir = new File ( path ) ;
    	if ( ! dir . exists ( ) )
    	{
        	if ( dir . mkdirs ( ) == false )
        	{
            	logger . log ( Level . SEVERE, "[FileUtil]-Cannot-create-directory." ) ;
            	return null ;
        	}
    	}
    	try
    	{
        	File newFile = File . createTempFile ( prefix, suffix, dir ) ;
        	return newFile ;
    	}
    	catch ( IOException e )
    	{
        	logger . log ( Level . SEVERE, e . getMessage ( ), e ) ;
        	return null ;
    	}
	}
	public void write ( ) throws IOException
	{
    	corruptPreUpgradeStorage ( root ) ;
    	write ( getVersionFile ( ) ) ;
	}
	public String toString ( )
	{
    	StringBuffer sb = toStringNoData ( ) ;
    	sb . append ( "<unknown-format>" ) ;
    	return sb . toString ( ) ;
	}
	public static void setInputCQLPageRowSize ( Configuration conf, String cqlPageRowSize )
	{
    	if ( cqlPageRowSize == null )
    	{
        	throw new UnsupportedOperationException ( "cql-page-row-size-may-not-be-null" ) ;
    	}
    	conf . set ( INPUT_CQL_PAGE_ROW_SIZE_CONFIG, cqlPageRowSize ) ;
	}
	void addPower ( Integer power, Prefix result )
	{
    	_powerMap . put ( power, result ) ;
	}
	public Complex asin ( )
	{
    	if ( isNaN ( ) )
    	{
        	return Complex . NaN ;
    	}
    	return sqrt1z ( ) . add ( this . multiply ( Complex . I ) ) . log ( ) . multiply ( Complex . I . negate ( ) ) ;
	}
	public static int rapidParseInt ( final String input )
	{
    	final int len = input . length ( ) ;
    	int val = 0 ;
    	int i = 0 ;
    	boolean isNegative = false ;
    	if ( 0 < len && '-' == input . charAt ( 0 ) )
    	{
        	i = 1 ;
        	isNegative = true ;
    	}
    	for ( ; i < len ; ++ i )
    	{
        	final char ch = input . charAt ( i ) ;
        	if ( Character . isDigit ( ch ) )
        	{
            	val = ( val * 10 ) + ( ch - 48 ) ;
        	}
        	else
        	{
            	break ;
        	}
    	}
    	if ( isNegative ) val = - val ;
    	return val ;
	}
	private int getSCFromCGIStatusHeader ( String value )
	{
    	if ( value . length ( ) < 3 )
    	{
        	log ( "runCGI:-invalid-status-value:" + value ) ;
        	return HttpServletResponse . SC_INTERNAL_SERVER_ERROR ;
    	}
    	String status = value . substring ( 0, 3 ) ;
    	int statusCode ;
    	try
    	{
        	statusCode = Integer . parseInt ( status ) ;
    	}
    	catch ( NumberFormatException nfe )
    	{
        	log ( "runCGI:-invalid-status-code:" + status ) ;
        	return HttpServletResponse . SC_INTERNAL_SERVER_ERROR ;
    	}
    	return statusCode ;
	}
	public static IOFileFilter asFileFilter ( FilenameFilter filter )
	{
    	return new DelegateFileFilter ( filter ) ;
	}
	public int hashCode ( )
	{
    	if ( hashCode == null ) hashCode = Integer . valueOf ( getClassName ( ) . hashCode ( ) + new HashSet ( Arrays . asList ( getAttributes ( ) ) ) . hashCode ( ) + new HashSet ( Arrays . asList ( getConstructors ( ) ) ) . hashCode ( ) + new HashSet ( Arrays . asList ( getNotifications ( ) ) ) . hashCode ( ) + new HashSet ( Arrays . asList ( getOperations ( ) ) ) . hashCode ( ) ) ;
    	return hashCode . intValue ( ) ;
	}
	public String printFlags ( )
	{
    	StringBuffer sb = new StringBuffer ( ) ;
    	for ( int i = 0 ; i < 16 ; i ++ ) if ( validFlag ( i ) && getFlag ( i ) )
        	{
            	sb . append ( Flags . string ( i ) ) ;
            	sb . append ( "-" ) ;
        	}
    	return sb . toString ( ) ;
	}
	public < P extends LocaleServiceProvider, S > S getLocalizedObject ( LocalizedObjectGetter < P, S > getter, Locale locale, Object ... params )
	{
    	return getLocalizedObjectImpl ( getter, locale, true, null, params ) ;
	}
	public String printPath ( final Vertex < T > vertex )
	{
    	String str = "" ;
    	if ( vertex != null )
    	{
        	str = "[" + vertex . getValue ( ) + "]" + "-->" + printPath ( vertex . getParent ( ) ) ;
    	}
    	return str ;
	}
	public void addVirtualSensorName ( java . lang . String param )
	{
    	if ( localVirtualSensorName == null )
    	{
        	localVirtualSensorName = new java . lang . String [ ] { } ;
    	}
    	localVirtualSensorNameTracker = true ;
    	java . util . List list = org . apache . axis2 . databinding . utils . ConverterUtil . toList ( localVirtualSensorName ) ;
    	list . add ( param ) ;
    	this . localVirtualSensorName = ( java . lang . String [ ] ) list . toArray ( new java . lang . String [ list . size ( ) ] ) ;
	}
	public void testSerialization ( )
	{
    	SpiderWebPlot p1 = new SpiderWebPlot ( new DefaultCategoryDataset ( ) ) ;
    	SpiderWebPlot p2 = null ;
    	try
    	{
        	ByteArrayOutputStream buffer = new ByteArrayOutputStream ( ) ;
        	ObjectOutput out = new ObjectOutputStream ( buffer ) ;
        	out . writeObject ( p1 ) ;
        	out . close ( ) ;
        	ObjectInput in = new ObjectInputStream ( new ByteArrayInputStream ( buffer . toByteArray ( ) ) ) ;
        	p2 = ( SpiderWebPlot ) in . readObject ( ) ;
        	in . close ( ) ;
    	}
    	catch ( Exception e )
    	{
        	e . printStackTrace ( ) ;
    	}
    	assertEquals ( p1, p2 ) ;
	}
	public List < String > getKeepTogether ( )
	{
    	if ( keepTogether == null )
    	{
        	keepTogether = new ArrayList < String > ( ) ;
    	}
    	return this . keepTogether ;
	}
	private void writeAttribute ( java . lang . String prefix, java . lang . String namespace, java . lang . String attName, java . lang . String attValue, javax . xml . stream . XMLStreamWriter xmlWriter ) throws javax . xml . stream . XMLStreamException
	{
    	if ( xmlWriter . getPrefix ( namespace ) == null )
    	{
        	xmlWriter . writeNamespace ( prefix, namespace ) ;
        	xmlWriter . setPrefix ( prefix, namespace ) ;
    	}
    	xmlWriter . writeAttribute ( namespace, attName, attValue ) ;
	}
	protected void updateInsertionLocation ( JComponent comp, Point p )
	{
    	JTable table = ( JTable ) comp ;
    	int row = table . rowAtPoint ( p ) ;
    	int col = table . columnAtPoint ( p ) ;
    	if ( row != - 1 )
    	{
        	table . setRowSelectionInterval ( row, row ) ;
    	}
    	if ( col != - 1 )
    	{
        	table . setColumnSelectionInterval ( col, col ) ;
    	}
	}
	@ Override 
	public boolean isSelectAllEnabled ( )
	{
    	if ( text == null || text . isDisposed ( ) )
    	{
        	return false ;
    	}
    	return text . getCharCount ( ) > 0 ;
	}
	public void error ( TransformerException exception ) throws TransformerException
	{
    	if ( m_throwExceptionOnError ) throw exception ;
    	else
    	{
        	printLocation ( m_pw, exception ) ;
        	m_pw . println ( exception . getMessage ( ) ) ;
    	}
	}
	@ XmlElementDecl ( namespace = "", name = "last-name" ) 
	public JAXBElement < String > createLastName ( String value )
	{
    	return new JAXBElement < String > ( _LastName_QNAME, String . class, null, value ) ;
	}
	public void removeChangeListener ( ChangeListener l )
	{
    	listenerList . remove ( ChangeListener . class, l ) ;
	}
	public static final Set < Method > findMethod ( Class clazz, Class < ? extends Annotation > annotationType )
	{
    	Method [ ] declaredMethods = org . springframework . util . ReflectionUtils . getAllDeclaredMethods ( clazz ) ;
    	Set < Method > results = new HashSet < Method > ( ) ;
    	for ( Method curMethod : declaredMethods )
    	{
        	Annotation annotation = AnnotationUtils . findAnnotation ( curMethod, annotationType ) ;
        	if ( annotation != null )
        	{
            	results . add ( curMethod ) ;
        	}
    	}
    	return results ;
	}
	public static void gc ( )
	{
    	Runtime . getRuntime ( ) . gc ( ) ;
	}
	public static boolean isWhitespace ( final CharSequence cs )
	{
    	if ( cs == null )
    	{
        	return false ;
    	}
    	final int sz = cs . length ( ) ;
    	for ( int i = 0 ; i < sz ; i ++ )
    	{
        	if ( Character . isWhitespace ( cs . charAt ( i ) ) == false )
        	{
            	return false ;
        	}
    	}
    	return true ;
	}
	private static void setMaxFraudReportDays ( String asMaxFraudReportDays )
	{
    	try
    	{
        	siMaxFraudReportDays = Integer . parseInt ( asMaxFraudReportDays . trim ( ) ) ;
    	}
    	catch ( Throwable aeThrowable )
    	{
        	siMaxFraudReportDays = DEFAULT_MAX_FRAUD_REPORT_DAYS ;
        	System . out . println ( DEFAULT_MAX_FRAUD_REPORT_DAYS_MSG ) ;
    	}
	}
	public static void repaintSelection ( JTree tree )
	{
    	int [ ] selectedRows = tree . getSelectionRows ( ) ;
    	if ( selectedRows != null && selectedRows . length > 0 )
    	{
        	Rectangle firstSelectedCell = tree . getRowBounds ( selectedRows [ 0 ] ) ;
        	Rectangle lastSelectedCell = tree . getRowBounds ( selectedRows [ selectedRows . length - 1 ] ) ;
        	Rectangle repaintRectangle = firstSelectedCell . union ( lastSelectedCell ) ;
        	repaintRectangle . x = 0 ;
        	repaintRectangle . width = tree . getWidth ( ) ;
        	tree . repaint ( repaintRectangle ) ;
    	}
	}
	public boolean intersects ( Range range )
	{
    	return intersects ( range . getLowerBound ( ), range . getUpperBound ( ) ) ;
	}
	public void removeComponent ( String subdomain )
	{
    	List < Component > componentsToRemove = new ArrayList < Component > ( routables . get ( subdomain ) . getComponents ( ) ) ;
    	for ( Component component : componentsToRemove )
    	{
        	removeComponent ( subdomain, component ) ;
    	}
	}
	public boolean isValid ( Document dirtyDocument )
	{
    	Validate . notNull ( dirtyDocument ) ;
    	Document clean = Document . createShell ( dirtyDocument . baseUri ( ) ) ;
    	int numDiscarded = copySafeNodes ( dirtyDocument . body ( ), clean . body ( ) ) ;
    	return numDiscarded == 0 ;
	}
	public void setLabelAngle ( double angle )
	{
    	this . labelAngle = angle ;
    	fireChangeEvent ( ) ;
	}
	public Properties getProperties ( int globalID )
	{
    	return ( Properties ) props . get ( new Integer ( globalID ) ) ;
	}
	public static String getDefaultSelectedTalendType ( String dbmsId, String dbmsType, int length, int precison )
	{
    	if ( dbmsId == null || "" . equals ( dbmsId ) || dbmsType == null || "" . equals ( dbmsType ) )
    	{
        	return "id_String" ;
    	}
    	loadAll ( ) ;
    	if ( DB_TO_TALEND_TYPES . get ( dbmsId . toLowerCase ( ) ) != null )
    	{
        	return DB_TO_TALEND_TYPES . get ( dbmsId . toLowerCase ( ) ) . get ( dbmsType ) ;
    	}
    	return "id_String" ;
	}
	public String getStoreUri ( )
	{
    	String security ;
    	switch ( mFlags & ( FLAG_SSL | FLAG_TLS | FLAG_TRUST_ALL_CERTIFICATES ) )
    	{
    	case FLAG_SSL :
        	security = "+ssl+" ;
        	break ;
    	case FLAG_SSL | FLAG_TRUST_ALL_CERTIFICATES :
        	security = "+ssl+trustallcerts" ;
        	break ;
    	case FLAG_TLS :
        	security = "+tls+" ;
        	break ;
    	case FLAG_TLS | FLAG_TRUST_ALL_CERTIFICATES :
        	security = "+tls+trustallcerts" ;
        	break ;
    	default :
        	security = "" ;
        	break ;
    	}
    	String userInfo = null ;
    	if ( ( mFlags & FLAG_AUTHENTICATE ) != 0 )
    	{
        	String trimUser = ( mLogin != null ) ? mLogin . trim ( ) : "" ;
        	String password = ( mPassword != null ) ? mPassword : "" ;
        	userInfo = trimUser + ":" + password ;
    	}
    	String address = ( mAddress != null ) ? mAddress . trim ( ) : null ;
    	String path = ( mDomain != null ) ? "/" + mDomain : null ;
    	URI uri ;
    	try
    	{
        	uri = new URI ( mProtocol + security, userInfo, address, mPort, path, null, null ) ;
        	return uri . toString ( ) ;
    	}
    	catch ( URISyntaxException e )
    	{
        	return null ;
    	}
	}
	public void setEnabled ( boolean flag )
	{
    	enabled = flag ;
    	if ( ! flag )
    	{
        	hideTipWindow ( ) ;
    	}
	}
	public static void forEachRemaining ( Spliterator . OfLong this_, LongConsumer action )
	{
    	do { }
    	while ( this_ . tryAdvance ( action ) ) ;
	}
	public static Preferences systemRoot ( )
	{
    	return factory . systemRoot ( ) ;
	}
	void loadSynchronousMessages ( )
	{
    	if ( DebugFlags . LOAD_LISTENER && ! mSynchronous )
    	{
        	throw new AssertionError ( ) ;
    	}
    	while ( ! mMessageQueue . isEmpty ( ) )
    	{
        	handleMessage ( mMessageQueue . remove ( 0 ) ) ;
    	}
	}
	public void obtainQueryTerms ( MatchingQueryTerms terms )
	{
    	for ( Query child : v )
    	{
        	child . obtainQueryTerms ( terms, true ) ;
    	}
    	ArrayList < Query > alist = new ArrayList < Query > ( ) ;
    	this . getTerms ( alist ) ;
    	terms . addDocumentScoreModifier ( new PhraseScoreModifier ( alist, proximityDistance ) ) ;
	}
	public String [ ] getPropertyNames ( )
	{
    	String [ ] statsNames = new String [ ] { ZonalStatsDescriptor . ZS_PROPERTY } ;
    	String [ ] superNames = super . getPropertyNames ( ) ;
    	if ( superNames == null )
    	{
        	return statsNames ;
    	}
    	List extraNames = new ArrayList ( ) ;
    	for ( int i = 0 ; i < statsNames . length ; i ++ )
    	{
        	String prefix = statsNames [ i ] ;
        	String [ ] names = PropertyUtil . getPropertyNames ( superNames, prefix ) ;
        	if ( names != null )
        	{
            	for ( int j = 0 ; j < names . length ; j ++ )
            	{
                	if ( names [ j ] . equalsIgnoreCase ( prefix ) )
                	{
                    	extraNames . add ( prefix ) ;
                	}
            	}
        	}
    	}
    	if ( extraNames . size ( ) == 0 )
    	{
        	return superNames ;
    	}
    	String [ ] propNames = new String [ superNames . length + extraNames . size ( ) ] ;
    	System . arraycopy ( superNames, 0, propNames, 0, superNames . length ) ;
    	int offset = superNames . length ;
    	for ( int i = 0 ; i < extraNames . size ( ) ; i ++ )
    	{
        	propNames [ offset ++ ] = ( String ) extraNames . get ( i ) ;
    	}
    	return propNames ;
	}
	private void writeQName ( javax . xml . namespace . QName qname, javax . xml . stream . XMLStreamWriter xmlWriter ) throws javax . xml . stream . XMLStreamException
	{
    	java . lang . String namespaceURI = qname . getNamespaceURI ( ) ;
    	if ( namespaceURI != null )
    	{
        	java . lang . String prefix = xmlWriter . getPrefix ( namespaceURI ) ;
        	if ( prefix == null )
        	{
            	prefix = generatePrefix ( namespaceURI ) ;
            	xmlWriter . writeNamespace ( prefix, namespaceURI ) ;
            	xmlWriter . setPrefix ( prefix, namespaceURI ) ;
        	}
        	if ( prefix . trim ( ) . length ( ) > 0 )
        	{
            	xmlWriter . writeCharacters ( prefix + ":" + org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( qname ) ) ;
        	}
        	else
        	{
            	xmlWriter . writeCharacters ( org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( qname ) ) ;
        	}
    	}
    	else
    	{
        	xmlWriter . writeCharacters ( org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( qname ) ) ;
    	}
	}
	public static boolean isValidIPV4Address ( String value )
	{
    	int periods = 0 ;
    	int i = 0 ;
    	int length = value . length ( ) ;
    	if ( length > 15 ) return false ;
    	char c = 0 ;
    	String word = "" ;
    	for ( i = 0 ; i < length ; i ++ )
    	{
        	c = value . charAt ( i ) ;
        	if ( c == '.' )
        	{
            	periods ++ ;
            	if ( periods > 3 ) return false ;
            	if ( word == "" ) return false ;
            	if ( Integer . parseInt ( word ) > 255 ) return false ;
            	word = "" ;
        	}
        	else if ( ! ( Character . isDigit ( c ) ) ) return false ;
        	else
        	{
            	if ( word . length ( ) > 2 ) return false ;
            	word += c ;
        	}
    	}
    	if ( word == "" || Integer . parseInt ( word ) > 255 ) return false ;
    	if ( periods != 3 ) return false ;
    	return true ;
	}
	private int findPrecedingOrAncestorOrSelf ( XPathContext xctxt, XPath fromMatchPattern, XPath countMatchPattern, int context, ElemNumber namespaceContext ) throws javax . xml . transform . TransformerException
	{
    	DTM dtm = xctxt . getDTM ( context ) ;
    	while ( DTM . NULL != context )
    	{
        	if ( null != fromMatchPattern )
        	{
            	if ( fromMatchPattern . getMatchScore ( xctxt, context ) != XPath . MATCH_SCORE_NONE )
            	{
                	context = DTM . NULL ;
                	break ;
            	}
        	}
        	if ( null != countMatchPattern )
        	{
            	if ( countMatchPattern . getMatchScore ( xctxt, context ) != XPath . MATCH_SCORE_NONE )
            	{
                	break ;
            	}
        	}
        	int prevSibling = dtm . getPreviousSibling ( context ) ;
        	if ( DTM . NULL == prevSibling )
        	{
            	context = dtm . getParent ( context ) ;
        	}
        	else
        	{
            	context = dtm . getLastChild ( prevSibling ) ;
            	if ( context == DTM . NULL ) context = prevSibling ;
        	}
    	}
    	return context ;
	}
	public final Script compileString ( String source, String sourceName, int lineno, Object securityDomain )
	{
    	if ( lineno < 0 )
    	{
        	lineno = 0 ;
    	}
    	return compileString ( source, null, null, sourceName, lineno, securityDomain ) ;
	}
	public void setArc ( Point2D p, Dimension2D d, double start, double extent, int type )
	{
    	setArc ( p . getX ( ), p . getY ( ), d . getWidth ( ), d . getHeight ( ), start, extent, type ) ;
	}
	public static DocumentBuilder getValidatingXmlParser ( File schemaFile )
	{
    	DocumentBuilder db = null ;
    	try
    	{
        	DocumentBuilderFactory dbf = DocumentBuilderFactory . newInstance ( ) ;
        	SchemaFactory factory = SchemaFactory . newInstance ( XMLConstants . W3C_XML_SCHEMA_NS_URI ) ;
        	Schema schema = factory . newSchema ( schemaFile ) ;
        	dbf . setSchema ( schema ) ;
        	db = dbf . newDocumentBuilder ( ) ;
        	db . setErrorHandler ( new SAXErrorHandler ( ) ) ;
    	}
    	catch ( ParserConfigurationException e )
    	{
        	System . err . printf ( "%s:-Unable-to-create-XML-parser-", XMLUtils . class . getName ( ) ) ;
        	e . printStackTrace ( ) ;
    	}
    	catch ( SAXException e )
    	{
        	System . err . printf ( "%s:-XML-parsing-exception-while-loading-schema-%s-", XMLUtils . class . getName ( ), schemaFile . getPath ( ) ) ;
        	e . printStackTrace ( ) ;
    	}
    	catch ( UnsupportedOperationException e )
    	{
        	System . err . printf ( "%s:-API-error-while-setting-up-XML-parser.-Check-your-JAXP-version-", XMLUtils . class . getName ( ) ) ;
        	e . printStackTrace ( ) ;
    	}
    	return db ;
	}
	public final ScriptableObject initStandardObjects ( )
	{
    	return initStandardObjects ( null, false ) ;
	}
	public static String convertFrameID22To23 ( String identifier )
	{
    	if ( identifier . length ( ) < 3 )
    	{
        	return null ;
    	}
    	return ID3Frames . convertv22Tov23 . get ( identifier . subSequence ( 0, 3 ) ) ;
	}
	public void onRestoreInstanceState ( Bundle savedInstanceState )
	{
    	final Bundle dialogHierarchyState = savedInstanceState . getBundle ( DIALOG_HIERARCHY_TAG ) ;
    	if ( dialogHierarchyState == null )
    	{
        	return ;
    	}
    	dispatchOnCreate ( savedInstanceState ) ;
    	mWindow . restoreHierarchyState ( dialogHierarchyState ) ;
    	if ( savedInstanceState . getBoolean ( DIALOG_SHOWING_TAG ) )
    	{
        	show ( ) ;
    	}
	}
	private void setHeadAndPropagate ( Node node, int propagate )
	{
    	Node h = head ;
    	setHead ( node ) ;
    	if ( propagate > 0 || h == null || h . waitStatus < 0 )
    	{
        	Node s = node . next ;
        	if ( s == null || s . isShared ( ) ) doReleaseShared ( ) ;
    	}
	}
	public void addCategory ( String name, Rights rights )
	{
    	Iterator < Song > it = library . iterator ( ) ;
    	while ( it . hasNext ( ) )
    	{
        	Song song = it . next ( ) ;
        	song . updateCategory ( name, rights ) ;
    	}
	}
	public static Set < String > getStopWords ( ) throws IOException
	{
    	Set < String > stopWords = new LinkedHashSet < String > ( ) ;
    	BufferedReader br = new BufferedReader ( new FileReader ( STOPWORDS_FILE ) ) ;
    	for ( String line ; ( line = br . readLine ( ) ) != null ; ) stopWords . add ( line . trim ( ) ) ;
    	br . close ( ) ;
    	return stopWords ;
	}
	@ Override 
	protected String toExternalForm ( URL url )
	{
    	StringBuilder sb = new StringBuilder ( ) ;
    	sb . append ( "jar:" ) ;
    	sb . append ( url . getFile ( ) ) ;
    	String ref = url . getRef ( ) ;
    	if ( ref != null )
    	{
        	sb . append ( ref ) ;
    	}
    	return sb . toString ( ) ;
	}
	public static List < Runnable > shutdownNow ( ExecutorService executorService )
	{
    	List < Runnable > answer = null ;
    	if ( ! executorService . isShutdown ( ) )
    	{
        	LOG . debug ( "Forcing-shutdown-of-ExecutorService:-{}", executorService ) ;
        	answer = executorService . shutdownNow ( ) ;
        	if ( LOG . isTraceEnabled ( ) )
        	{
            	LOG . trace ( "Shutdown-of-ExecutorService:-{}-is-shutdown:-{}-and-terminated:-{}.", new Object [ ] { executorService, executorService . isShutdown ( ), executorService . isTerminated ( ) } ) ;
        	}
    	}
    	return answer ;
	}
	static void setOnPreferenceTreeClickListener ( PreferenceManager manager, final OnPreferenceTreeClickListener listener )
	{
    	try
    	{
        	Field onPreferenceTreeClickListener = PreferenceManager . class . getDeclaredField ( "mOnPreferenceTreeClickListener" ) ;
        	onPreferenceTreeClickListener . setAccessible ( true ) ;
        	if ( listener != null )
        	{
            	Object proxy = Proxy . newProxyInstance ( onPreferenceTreeClickListener . getType ( ) . getClassLoader ( ), new Class [ ] { onPreferenceTreeClickListener . getType ( ) }, new InvocationHandler ( )
            	{
                	public Object invoke ( Object proxy, Method method, Object [ ] args )
                	{
                    	if ( method . getName ( ) . equals ( "onPreferenceTreeClick" ) )
                    	{
                        	return Boolean . valueOf ( listener . onPreferenceTreeClick ( ( PreferenceScreen ) args [ 0 ], ( Preference ) args [ 1 ] ) ) ;
                    	}
                    	else
                    	{
                        	return null ;
                    	}
                	}
            	} ) ;
            	onPreferenceTreeClickListener . set ( manager, proxy ) ;
        	}
        	else
        	{
            	onPreferenceTreeClickListener . set ( manager, null ) ;
        	}
    	}
    	catch ( Exception e )
    	{
        	Log . w ( TAG, "Couldn't-set-PreferenceManager.mOnPreferenceTreeClickListener-by-reflection", e ) ;
    	}
	}
	public synchronized void reset ( ) throws IOException
	{
    	getBufIfOpen ( ) ;
    	if ( markpos < 0 ) throw new IOException ( "Resetting-to-invalid-mark" ) ;
    	pos = markpos ;
	}
	public Graph convertBuchi ( gov . nasa . ltl . graph . Graph < String > buchi )
	{
    	Graph graph = new Graph ( ) ;
    	for ( gov . nasa . ltl . graph . Node < String > node : buchi . getNodes ( ) )
    	{
        	Node state = new Node ( node . getBooleanAttribute ( "accepting" ), node . getId ( ) ) ;
        	if ( ! graph . contains ( node . getId ( ) ) ) graph . addNode ( state, node . getId ( ) ) ;
        	for ( gov . nasa . ltl . graph . Edge < String > edge : node . getOutgoingEdges ( ) )
        	{
            	Edge transition = new Edge ( ) ;
            	gov . nasa . ltl . graph . Guard < String > buchiGuard = edge . getGuard ( ) ;
            	Guard guard = new Guard ( buchiGuard ) ;
            	transition . addGuard ( guard ) ;
            	state . addOutgoingEdge ( transition ) ;
            	transition . setSource ( state ) ;
            	gov . nasa . ltl . graph . Node < String > nextNode = edge . getNext ( ) ;
            	Node nextState = graph . getNode ( nextNode . getId ( ) ) ;
            	if ( nextState == null )
            	{
                	nextState = new Node ( nextNode . getBooleanAttribute ( "accepting" ), nextNode . getId ( ) ) ;
                	graph . addNode ( nextState, nextNode . getId ( ) ) ;
            	}
            	nextState . addIncomingEdge ( transition ) ;
            	transition . setNext ( nextState ) ;
        	}
    	}
    	return graph ;
	}
	private Entry < K, V > removeEntryForKey ( K key )
	{
    	int hash = hash ( key ) ;
    	int i = hashIndex ( hash, entries . length ) ;
    	Entry < K, V > prev = entries [ i ] ;
    	Entry < K, V > e = prev ;
    	while ( e != null )
    	{
        	Entry < K, V > next = e . next ;
        	if ( e . hash == hash && isEqual ( key, e . key ) )
        	{
            	size -- ;
            	if ( prev == e )
            	{
                	entries [ i ] = next ;
            	}
            	else
            	{
                	prev . next = next ;
            	}
            	Entry < K, V > prevPtr = e . getPrevPtr ( ) ;
            	Entry < K, V > nextPtr = e . getNextPtr ( ) ;
            	if ( prevPtr != null && nextPtr != null )
            	{
                	prevPtr . setNextPtr ( nextPtr ) ;
                	nextPtr . setPrevPtr ( prevPtr ) ;
            	}
            	else if ( prevPtr != null )
            	{
                	tailPtr = prevPtr ;
                	prevPtr . setNextPtr ( null ) ;
            	}
            	else if ( nextPtr != null )
            	{
                	headPtr = nextPtr ;
                	nextPtr . setPrevPtr ( null ) ;
            	}
            	return e ;
        	}
        	prev = e ;
        	e = next ;
    	}
    	return e ;
	}
	void write ( DataOutput par1DataOutput ) throws IOException
	{
    	par1DataOutput . writeFloat ( this . data ) ;
	}
	public static boolean getBoolean ( )
	{
    	boolean ans = false ;
    	while ( true )
    	{
        	String s = getWord ( ) ;
        	if ( s . equalsIgnoreCase ( "true" ) || s . equalsIgnoreCase ( "t" ) || s . equalsIgnoreCase ( "yes" ) || s . equalsIgnoreCase ( "y" ) || s . equals ( "1" ) )
        	{
            	ans = true ;
            	break ;
        	}
        	else if ( s . equalsIgnoreCase ( "false" ) || s . equalsIgnoreCase ( "f" ) || s . equalsIgnoreCase ( "no" ) || s . equalsIgnoreCase ( "n" ) || s . equals ( "0" ) )
        	{
            	ans = false ;
            	break ;
        	}
        	else errorMessage ( "Illegal-boolean-input-value.", "one-of:-true,-false,-t,-f,-yes,-no,-y,-n,-0,-or-1" ) ;
    	}
    	inputErrorCount = 0 ;
    	return ans ;
	}
	public static Rectangle getLocalBounds ( Component aComponent )
	{
    	Rectangle b = new Rectangle ( aComponent . getBounds ( ) ) ;
    	b . x = b . y = 0 ;
    	return b ;
	}
	private static String getTranslation ( String [ ] p_74299_0_, int p_74299_1_ )
	{
    	if ( p_74299_1_ < 0 || p_74299_1_ >= p_74299_0_ . length )
    	{
        	p_74299_1_ = 0 ;
    	}
    	return I18n . format ( p_74299_0_ [ p_74299_1_ ], new Object [ 0 ] ) ;
	}
	public String readLine ( ) throws IOException
	{
    	synchronized ( in )
    	{
        	if ( buf == null )
        	{
            	throw new IOException ( "LineReader-is-closed" ) ;
        	}
        	if ( pos >= end )
        	{
            	fillBuf ( ) ;
        	}
        	for ( int i = pos ; i != end ; ++ i )
        	{
            	if ( buf [ i ] == LF )
            	{
                	int lineEnd = ( i != pos && buf [ i - 1 ] == CR ) ? i - 1 : i ;
                	String res = new String ( buf, pos, lineEnd - pos, charset . name ( ) ) ;
                	pos = i + 1 ;
                	return res ;
            	}
        	}
        	ByteArrayOutputStream out = new ByteArrayOutputStream ( end - pos + 80 )
        	{
            	@ Override public String toString ( )
            	{
                	int length = ( count > 0 && buf [ count - 1 ] == CR ) ? count - 1 : count ;
                	try
                	{
                    	return new String ( buf, 0, length, charset . name ( ) ) ;
                	}
                	catch ( UnsupportedEncodingException e )
                	{
                    	throw new AssertionError ( e ) ;
                	}
            	}
        	} ;
        	while ( true )
        	{
            	out . write ( buf, pos, end - pos ) ;
            	end = - 1 ;
            	fillBuf ( ) ;
            	for ( int i = pos ; i != end ; ++ i )
            	{
                	if ( buf [ i ] == LF )
                	{
                    	if ( i != pos )
                    	{
                        	out . write ( buf, pos, i - pos ) ;
                    	}
                    	pos = i + 1 ;
                    	return out . toString ( ) ;
                	}
            	}
        	}
    	}
	}
	public javax . xml . stream . XMLStreamReader getPullParser ( javax . xml . namespace . QName qName ) throws org . apache . axis2 . databinding . ADBException
	{
    	java . util . ArrayList elementList = new java . util . ArrayList ( ) ;
    	java . util . ArrayList attribList = new java . util . ArrayList ( ) ;
    	if ( localItemTracker )
    	{
        	if ( localItem != null )
        	{
            	for ( int i = 0 ; i < localItem . length ; i ++ )
            	{
                	if ( localItem [ i ] != null )
                	{
                    	elementList . add ( new javax . xml . namespace . QName ( "http://ec2.amazonaws.com/doc/2012-08-15/", "item" ) ) ;
                    	elementList . add ( localItem [ i ] ) ;
                	}
                	else { }
            	}
        	}
        	else
        	{
            	throw new org . apache . axis2 . databinding . ADBException ( "item-cannot-be-null!!" ) ;
        	}
    	}
    	return new org . apache . axis2 . databinding . utils . reader . ADBXMLStreamReaderImpl ( qName, elementList . toArray ( ), attribList . toArray ( ) ) ;
	}
	public static WritableRaster createInterleavedRaster ( DataBuffer dataBuffer, int w, int h, int scanlineStride, int pixelStride, int bandOffsets [ ], Point location )
	{
    	if ( w <= 0 || h <= 0 )
    	{
        	throw new RasterFormatException ( Messages . getString ( "awt.22E" ) ) ;
    	}
    	if ( location == null )
    	{
        	location = new Point ( 0, 0 ) ;
    	}
    	if ( ( long ) location . x + w > Integer . MAX_VALUE || ( long ) location . y + h > Integer . MAX_VALUE )
    	{
        	throw new RasterFormatException ( Messages . getString ( "awt.276" ) ) ;
    	}
    	if ( dataBuffer == null )
    	{
        	throw new NullPointerException ( Messages . getString ( "awt.278" ) ) ;
    	}
    	int dataType = dataBuffer . getDataType ( ) ;
    	if ( dataType != DataBuffer . TYPE_BYTE && dataType != DataBuffer . TYPE_USHORT )
    	{
        	throw new IllegalArgumentException ( Messages . getString ( "awt.230" ) ) ;
    	}
    	if ( dataBuffer . getNumBanks ( ) > 1 )
    	{
        	throw new RasterFormatException ( Messages . getString ( "awt.27A" ) ) ;
    	}
    	if ( bandOffsets == null )
    	{
        	throw new NullPointerException ( Messages . getString ( "awt.27B" ) ) ;
    	}
    	PixelInterleavedSampleModel sampleModel = new PixelInterleavedSampleModel ( dataType, w, h, pixelStride, scanlineStride, bandOffsets ) ;
    	return new OrdinaryWritableRaster ( sampleModel, dataBuffer, location ) ;
	}
	public static double utcOffset ( )
	{
    	Calendar cal = Calendar . getInstance ( ) ;
    	return 4 * 60 * 60 - ( cal . get ( Calendar . ZONE_OFFSET ) + cal . get ( Calendar . DST_OFFSET ) ) / 1000 ;
	}
	public AttributeSet getCharacterAttribute ( int i )
	{
    	if ( model instanceof StyledDocument )
    	{
        	StyledDocument doc = ( StyledDocument ) model ;
        	Element elem = doc . getCharacterElement ( i ) ;
        	if ( elem != null )
        	{
            	return elem . getAttributes ( ) ;
        	}
    	}
    	return null ;
	}
	public static Rect getFrameForView ( View v )
	{
    	int location [ ] = new int [ 2 ] ;
    	v . getLocationOnScreen ( location ) ;
    	Rect viewRect = new Rect ( location [ 0 ], location [ 1 ], location [ 0 ] + v . getWidth ( ), location [ 1 ] + v . getHeight ( ) ) ;
    	return viewRect ;
	}
	SimpleTerminologyAccess ( String id )
	{
    	this . id = id ;
    	this . groups = new HashMap < String, Set < CodePhrase >> ( ) ;
    	this . groupLangNameToId = new HashMap < String, Map < String, String >> ( ) ;
    	this . codeRubrics = new HashMap < String, Map < String, String >> ( ) ;
	}
	public void setLocations ( ArrayList < Location > locations )
	{
    	this . locations = locations ;
    	pathLength = 0.0 ;
    	for ( int i = 0 ; i < locations . size ( ) - 1 ; ++ i )
    	{
        	Location l1 = locations . get ( i ) ;
        	Location l2 = locations . get ( i + 1 ) ;
        	pathLength += l1 . distance ( l2 ) ;
    	}
	}
	public static String decodeEncodedWords ( String body, Message message )
	{
    	if ( body . indexOf ( "=?" ) == - 1 )
    	{
        	return body ;
    	}
    	int previousEnd = 0 ;
    	boolean previousWasEncoded = false ;
    	StringBuilder sb = new StringBuilder ( ) ;
    	while ( true )
    	{
        	int begin = body . indexOf ( "=?", previousEnd ) ;
        	int endScan = begin + 2 ;
        	if ( begin != - 1 )
        	{
            	int qm1 = body . indexOf ( '?', endScan + 2 ) ;
            	int qm2 = body . indexOf ( '?', qm1 + 1 ) ;
            	if ( qm2 != - 1 )
            	{
                	endScan = qm2 + 1 ;
            	}
        	}
        	int end = begin == - 1 ? - 1 : body . indexOf ( "?=", endScan ) ;
        	if ( end == - 1 )
        	{
            	if ( previousEnd == 0 ) return body ;
            	sb . append ( body . substring ( previousEnd ) ) ;
            	return sb . toString ( ) ;
        	}
        	end += 2 ;
        	String sep = body . substring ( previousEnd, begin ) ;
        	String decoded = decodeEncodedWord ( body, begin, end, message ) ;
        	if ( decoded == null )
        	{
            	sb . append ( sep ) ;
            	sb . append ( body . substring ( begin, end ) ) ;
        	}
        	else
        	{
            	if ( ! previousWasEncoded || ! CharsetUtil . isWhitespace ( sep ) )
            	{
                	sb . append ( sep ) ;
            	}
            	sb . append ( decoded ) ;
        	}
        	previousEnd = end ;
        	previousWasEncoded = decoded != null ;
    	}
	}
	public static String getMessage ( final int code, int subCode, final Object [ ] add )
	{
    	String message = getResourceString ( code ) ;
    	if ( subCode != 0 )
    	{
        	message += getResourceString ( subCode ) ;
    	}
    	if ( add != null )
    	{
        	message = insertStrings ( message, add ) ;
    	}
    	return message ;
	}
	public float getFloat ( String name, String category, float defaultValue, float minValue, float maxValue, String comment )
	{
    	return getFloat ( name, category, defaultValue, minValue, maxValue, comment, name ) ;
	}
	private void writeAttribute ( java . lang . String prefix, java . lang . String namespace, java . lang . String attName, java . lang . String attValue, javax . xml . stream . XMLStreamWriter xmlWriter ) throws javax . xml . stream . XMLStreamException
	{
    	if ( xmlWriter . getPrefix ( namespace ) == null )
    	{
        	xmlWriter . writeNamespace ( prefix, namespace ) ;
        	xmlWriter . setPrefix ( prefix, namespace ) ;
    	}
    	xmlWriter . writeAttribute ( namespace, attName, attValue ) ;
	}
	public final static < T1, T2, R > Observable < R > zip ( Observable < ? extends T1 > o1, Observable < ? extends T2 > o2, final Func2 < ? super T1, ? super T2, ? extends R > zipFunction )
	{
    	return just ( new Observable < ? > [ ] { o1, o2 } ) . lift ( new OperatorZip < R > ( zipFunction ) ) ;
	}
	public static void configureVertica ( Configuration conf, String [ ] hostnames, String database, String username, String password )
	{
    	conf . setStrings ( HOSTNAMES_PROP, hostnames ) ;
    	conf . set ( DATABASE_PROP, database ) ;
    	conf . set ( USERNAME_PROP, username ) ;
    	conf . set ( PASSWORD_PROP, password ) ;
	}
	public void add ( String name, T val )
	{
    	nvPairs . add ( name ) ;
    	nvPairs . add ( val ) ;
	}
	public CharSequence subSequence ( int start, int end )
	{
    	return substring ( start, end ) ;
	}
	public void removeActivationName ( String name )
	{
    	if ( sealed ) onSealedMutation ( ) ;
    	if ( activationNames != null ) activationNames . remove ( name ) ;
	}
	public int numUniqueTokens ( )
	{
    	return tokenSet . size ( ) ;
	}
	public void endElement ( QName element, Augmentations augs ) throws XNIException
	{
    	if ( fNamespaces )
    	{
        	handleEndElement ( element, augs, false ) ;
    	}
    	else if ( fDocumentHandler != null )
    	{
        	fDocumentHandler . endElement ( element, augs ) ;
    	}
	}
	public static final String getBluetoothHeadsetPriorityKey ( String address )
	{
    	return ( "bluetooth_headset_priority_" + address . toUpperCase ( ) ) ;
	}
	public static void extractURL ( String request, int beginIndex, final Map < Integer, RequestComponent > requestComponents )
	{
    	logger . debug ( "extractURL-called..." ) ;
    	logger . debug ( "request=" + request ) ;
    	logger . debug ( "beginIndex=" + beginIndex ) ;
    	if ( StringUtils . isEmpty ( request ) )
    	{
        	return ;
    	}
    	if ( beginIndex >= request . length ( ) )
    	{
        	return ;
    	}
    	if ( requestComponents == null )
    	{
        	logger . error ( "requestComponents-cannot-be-null" ) ;
        	throw new SVNTechnicalException ( "requestComponents-cannot-be-null" ) ;
    	}
    	final String urlToken = "svn+ssh" ;
    	String temp = request . substring ( beginIndex ) ;
    	logger . debug ( "extractURL-in-" + temp ) ;
    	if ( temp . contains ( urlToken ) )
    	{
        	int indexCommand = temp . indexOf ( urlToken ) ;
        	if ( indexCommand >= 0 )
        	{
            	temp = temp . substring ( indexCommand ) ;
            	int index = temp . indexOf ( "-" ) ;
            	if ( index > 1 )
            	{
                	temp = temp . substring ( 0, index ) ;
            	}
            	RequestComponent component = new RequestComponentUrl ( request, temp ) ;
            	requestComponents . put ( ( indexCommand + beginIndex ), component ) ;
            	if ( logger . isDebugEnabled ( ) )
            	{
                	logger . debug ( "extracted=" + component . toString ( ) ) ;
            	}
            	extractURL ( request, indexCommand + beginIndex + 1, requestComponents ) ;
        	}
    	}
	}
	public double getTotalResponseTime ( )
	{
    	if ( exitTimes == null || entryTimes == null )
    	{
        	return 0 ;
    	}
    	double time = 0 ;
    	try
    	{
        	double startTime = exitTimes . firstElement ( ) . doubleValue ( ) ;
        	double receiveTime = entryTimes . lastElement ( ) . doubleValue ( ) ;
        	time = receiveTime - startTime ;
    	}
    	catch ( Exception e )
    	{
        	time = 0 ;
    	}
    	return time ;
	}
	public Period match ( SortedMap < Period, ZoneStatus > zoneSchedule, long time )
	{
    	NDC . push ( "match" ) ;
    	try
    	{
        	Stack < Period > stack = new Stack < Period > ( ) ;
        	Date currentDate = new Date ( time ) ;
        	logger . debug ( "Matching-" + currentDate ) ;
        	SortedMap < Period, ZoneStatus > today = getToday ( zoneSchedule, currentDate ) ;
        	for ( Iterator < Period > i = today . keySet ( ) . iterator ( ) ; i . hasNext ( ) ; )
        	{
            	Period p = i . next ( ) ;
            	if ( p . includes ( currentDate ) )
            	{
                	logger . debug ( "Included-" + p ) ;
                	stack . push ( p ) ;
            	}
        	}
        	return stack . pop ( ) ;
    	}
    	finally
    	{
        	NDC . pop ( ) ;
    	}
	}
	public void println ( double x )
	{
    	out . println ( x ) ;
	}
	public final void load ( InputStream stream, char [ ] password ) throws IOException, NoSuchAlgorithmException, CertificateException
	{
    	implSpi . engineLoad ( stream, password ) ;
    	isInit = true ;
	}
	@ Override 
	public boolean containsValue ( Object value )
	{
    	HashMapEntry [ ] tab = table ;
    	int len = tab . length ;
    	if ( value == null )
    	{
        	for ( int i = 0 ; i < len ; i ++ )
        	{
            	for ( HashMapEntry e = tab [ i ] ; e != null ; e = e . next )
            	{
                	if ( e . value == null )
                	{
                    	return true ;
                	}
            	}
        	}
        	return entryForNullKey != null && entryForNullKey . value == null ;
    	}
    	for ( int i = 0 ; i < len ; i ++ )
    	{
        	for ( HashMapEntry e = tab [ i ] ; e != null ; e = e . next )
        	{
            	if ( value . equals ( e . value ) )
            	{
                	return true ;
            	}
        	}
    	}
    	return entryForNullKey != null && value . equals ( entryForNullKey . value ) ;
	}
	public static < K extends Comparable < ? >, V > Builder < K, V > builder ( )
	{
    	return new Builder < K, V > ( ) ;
	}
	public List < Double > getVelocity ( )
	{
    	if ( velocity == null )
    	{
        	velocity = new ArrayList < Double > ( ) ;
    	}
    	return this . velocity ;
	}
	public Value setAuthorityValue ( ) throws WingException
	{
    	return setAuthorityValue ( "", "UNSET" ) ;
	}
	public javax . xml . stream . XMLStreamReader getPullParser ( javax . xml . namespace . QName qName ) throws org . apache . axis2 . databinding . ADBException
	{
    	java . util . ArrayList elementList = new java . util . ArrayList ( ) ;
    	java . util . ArrayList attribList = new java . util . ArrayList ( ) ;
    	elementList . add ( new javax . xml . namespace . QName ( "http://ec2.amazonaws.com/doc/2012-08-15/", "snapshotId" ) ) ;
    	if ( localSnapshotId != null )
    	{
        	elementList . add ( org . apache . axis2 . databinding . utils . ConverterUtil . convertToString ( localSnapshotId ) ) ;
    	}
    	else
    	{
        	throw new org . apache . axis2 . databinding . ADBException ( "snapshotId-cannot-be-null!!" ) ;
    	}
    	return new org . apache . axis2 . databinding . utils . reader . ADBXMLStreamReaderImpl ( qName, elementList . toArray ( ), attribList . toArray ( ) ) ;
	}
	void setCacheColorHint ( int color )
	{
    	if ( mViewTypeCount == 1 )
    	{
        	final ArrayList < View > scrap = mCurrentScrap ;
        	final int scrapCount = scrap . size ( ) ;
        	for ( int i = 0 ; i < scrapCount ; i ++ )
        	{
            	scrap . get ( i ) . setDrawingCacheBackgroundColor ( color ) ;
        	}
    	}
    	else
    	{
        	final int typeCount = mViewTypeCount ;
        	for ( int i = 0 ; i < typeCount ; i ++ )
        	{
            	final ArrayList < View > scrap = mScrapViews [ i ] ;
            	final int scrapCount = scrap . size ( ) ;
            	for ( int j = 0 ; j < scrapCount ; j ++ )
            	{
                	scrap . get ( j ) . setDrawingCacheBackgroundColor ( color ) ;
            	}
        	}
    	}
    	final View [ ] activeViews = mActiveViews ;
    	final int count = activeViews . length ;
    	for ( int i = 0 ; i < count ; ++ i )
    	{
        	final View victim = activeViews [ i ] ;
        	if ( victim != null )
        	{
            	victim . setDrawingCacheBackgroundColor ( color ) ;
        	}
    	}
	}
	public SelectionBuilder where ( String selection, String ... selectionArgs )
	{
    	if ( TextUtils . isEmpty ( selection ) )
    	{
        	if ( selectionArgs != null && selectionArgs . length > 0 )
        	{
            	throw new IllegalArgumentException ( "Valid-selection-required-when-including-arguments=" ) ;
        	}
        	return this ;
    	}
    	if ( mSelection . length ( ) > 0 )
    	{
        	mSelection . append ( "-AND-" ) ;
    	}
    	mSelection . append ( "(" ) . append ( selection ) . append ( ")" ) ;
    	if ( selectionArgs != null )
    	{
        	Collections . addAll ( mSelectionArgs, selectionArgs ) ;
    	}
    	return this ;
	}
	private void killTasksWithMaxRssMemory ( long rssMemoryInUsage )
	{
    	List < TaskAttemptID > tasksToKill = new ArrayList < TaskAttemptID > ( ) ;
    	List < TaskAttemptID > allTasks = new ArrayList < TaskAttemptID > ( ) ;
    	allTasks . addAll ( processTreeInfoMap . keySet ( ) ) ;
    	Collections . sort ( allTasks, new Comparator < TaskAttemptID > ( )
    	{
        	public int compare ( TaskAttemptID tid1, TaskAttemptID tid2 )
        	{
            	return getTaskCumulativeRssmem ( tid1 ) < getTaskCumulativeRssmem ( tid2 ) ? - 1 : 1 ;
        	}
    	} ) ;
    	while ( rssMemoryInUsage > maxRssMemoryAllowedForAllTasks && ! allTasks . isEmpty ( ) )
    	{
        	TaskAttemptID tid = allTasks . remove ( allTasks . size ( ) - 1 ) ;
        	if ( ! isKillable ( tid ) )
        	{
            	continue ;
        	}
        	long rssmem = getTaskCumulativeRssmem ( tid ) ;
        	if ( rssmem == 0 )
        	{
            	break ;
        	}
        	tasksToKill . add ( tid ) ;
        	rssMemoryInUsage -= rssmem ;
    	}
    	if ( ! tasksToKill . isEmpty ( ) )
    	{
        	for ( TaskAttemptID tid : tasksToKill )
        	{
            	String msg = "Killing-one-of-the-memory-consuming-tasks---" + tid + ",-as-the-cumulative-RSS-memory-usage-of-all-the-tasks-on-" + "the-TaskTracker-exceeds-physical-memory-limit-" + maxRssMemoryAllowedForAllTasks + "." ;
            	LOG . warn ( msg ) ;
            	killTask ( tid, msg ) ;
        	}
    	}
    	else
    	{
        	LOG . info ( "The-total-physical-memory-usage-is-overflowing-TTs-limits.-" + "But-found-no-alive-task-to-kill-for-freeing-memory." ) ;
    	}
	}
	public java . lang . Boolean isVisible ( )
	{
    	return visible == null ? Boolean . valueOf ( true ) : visible ;
	}
	public boolean equalsIgnoreCase ( String anotherString )
	{
    	return ( this == anotherString ) ? true : ( anotherString != null ) && ( anotherString . count == count ) && regionMatches ( true, 0, anotherString, 0, count ) ;
	}
	public < T > T setDisabledColor ( String strColor, Class < T > returnType )
	{
    	String extension = "setDisabledColor("" + strColor + "")." ;
    	try
    	{
        	java . lang . reflect . Constructor < T > ctor = returnType . getConstructor ( Context . class, String . class ) ;
        	return ctor . newInstance ( this, extension ) ;
    	}
    	catch ( Exception ex )
    	{
        	throw new IllegalArgumentException ( "Unsupported-return-type:-" + returnType . getName ( ) ) ;
    	}
	}
	public final Collection < ? extends CRL > getCRLs ( CRLSelector selector ) throws CertStoreException
	{
    	return spiImpl . engineGetCRLs ( selector ) ;
	}
	public static int printUsage ( String [ ] args, String usage )
	{
    	err . println ( "args-=-" + Arrays . asList ( args ) ) ;
    	err . println ( ) ;
    	err . println ( "Usage:-java-" + usage ) ;
    	err . println ( ) ;
    	ToolRunner . printGenericCommandUsage ( err ) ;
    	return - 1 ;
	}
	public void add ( int el )
	{
    	int n = wordNumber ( el ) ;
    	if ( n >= bits . length )
    	{
        	growToInclude ( el ) ;
    	}
    	bits [ n ] |= bitMask ( el ) ;
	}
	public Builder withMarshallerNoNamespaceSchemaLocation ( String value )
	{
    	properties . put ( Marshaller . JAXB_NO_NAMESPACE_SCHEMA_LOCATION, value ) ;
    	return this ;
	}
	public NamedObject ( String objectName, DynamicMBean object ) throws MalformedObjectNameException
	{
    	ObjectName objName = new ObjectName ( objectName ) ;
    	if ( objName . isPattern ( ) )
    	{
        	throw new RuntimeOperationsException ( new IllegalArgumentException ( "Invalid-name->" + objName . toString ( ) ) ) ;
    	}
    	this . name = objName ;
    	this . object = object ;
	}
	public static String numberToString ( Number number ) throws JSONException
	{
    	if ( number == null )
    	{
        	throw new JSONException ( "Null-pointer" ) ;
    	}
    	testValidity ( number ) ;
    	String string = number . toString ( ) ;
    	if ( string . indexOf ( '.' ) > 0 && string . indexOf ( 'e' ) < 0 && string . indexOf ( 'E' ) < 0 )
    	{
        	while ( string . endsWith ( "0" ) )
        	{
            	string = string . substring ( 0, string . length ( ) - 1 ) ;
        	}
        	if ( string . endsWith ( "." ) )
        	{
            	string = string . substring ( 0, string . length ( ) - 1 ) ;
        	}
    	}
    	return string ;
	}
	public Object clone ( )
	{
    	ChoiceFormat other = ( ChoiceFormat ) super . clone ( ) ;
    	other . choiceLimits = ( double [ ] ) choiceLimits . clone ( ) ;
    	other . choiceFormats = ( String [ ] ) choiceFormats . clone ( ) ;
    	return other ;
	}
	public static BufferedReader openFileForBufferedUtf8Reading ( final File file )
	{
    	return new BufferedReader ( new InputStreamReader ( openFileForReading ( file ), Charset . forName ( "UTF-8" ) ) ) ;
	}
	public Rectangle2D getScreenDataArea ( )
	{
    	Rectangle2D dataArea = this . info . getPlotInfo ( ) . getDataArea ( ) ;
    	Insets insets = getInsets ( ) ;
    	double x = dataArea . getX ( ) * this . scaleX + insets . left ;
    	double y = dataArea . getY ( ) * this . scaleY + insets . top ;
    	double w = dataArea . getWidth ( ) * this . scaleX ;
    	double h = dataArea . getHeight ( ) * this . scaleY ;
    	return new Rectangle2D . Double ( x, y, w, h ) ;
	}
	@ Override 
	public void drawRangeLine ( Graphics2D g2, XYPlot plot, ValueAxis axis, Rectangle2D dataArea, double value, Paint paint, Stroke stroke )
	{
    	Range range = axis . getRange ( ) ;
    	if ( ! range . contains ( value ) )
    	{
        	return ;
    	}
    	PlotOrientation orientation = plot . getOrientation ( ) ;
    	Line2D line = null ;
    	double v = axis . valueToJava2D ( value, dataArea, plot . getRangeAxisEdge ( ) ) ;
    	if ( orientation == PlotOrientation . HORIZONTAL )
    	{
        	line = new Line2D . Double ( v, dataArea . getMinY ( ), v, dataArea . getMaxY ( ) ) ;
    	}
    	else if ( orientation == PlotOrientation . VERTICAL )
    	{
        	line = new Line2D . Double ( dataArea . getMinX ( ), v, dataArea . getMaxX ( ), v ) ;
    	}
    	g2 . setPaint ( paint ) ;
    	g2 . setStroke ( stroke ) ;
    	g2 . draw ( line ) ;
	}
	public static boolean isFilenameSafe ( File file )
	{
    	return SAFE_FILENAME_PATTERN . matcher ( file . getPath ( ) ) . matches ( ) ;
	}
	public float getTextRunAdvances ( char [ ] chars, int index, int count, int contextIndex, int contextCount, int flags, float [ ] advances, int advancesIndex )
	{
    	if ( chars == null )
    	{
        	throw new IllegalArgumentException ( "text-cannot-be-null" ) ;
    	}
    	if ( flags != DIRECTION_LTR && flags != DIRECTION_RTL )
    	{
        	throw new IllegalArgumentException ( "unknown-flags-value:-" + flags ) ;
    	}
    	if ( ( index | count | contextIndex | contextCount | advancesIndex | ( index - contextIndex ) | ( contextCount - count ) | ( ( contextIndex + contextCount ) - ( index + count ) ) | ( chars . length - ( contextIndex + contextCount ) ) | ( advances == null ? 0 : ( advances . length - ( advancesIndex + count ) ) ) ) < 0 )
    	{
        	throw new IndexOutOfBoundsException ( ) ;
    	}
    	if ( chars . length == 0 || count == 0 )
    	{
        	return 0f ;
    	}
    	if ( ! mHasCompatScaling )
    	{
        	return native_getTextRunAdvances ( mNativePaint, chars, index, count, contextIndex, contextCount, flags, advances, advancesIndex ) ;
    	}
    	final float oldSize = getTextSize ( ) ;
    	setTextSize ( oldSize * mCompatScaling ) ;
    	float res = native_getTextRunAdvances ( mNativePaint, chars, index, count, contextIndex, contextCount, flags, advances, advancesIndex ) ;
    	setTextSize ( oldSize ) ;
    	if ( advances != null )
    	{
        	for ( int i = advancesIndex, e = i + count ; i < e ; i ++ )
        	{
            	advances [ i ] *= mInvCompatScaling ;
        	}
    	}
    	return res * mInvCompatScaling ;
	}
	public List < Float > getFloat1X2 ( )
	{
    	if ( float1X2 == null )
    	{
        	float1X2 = new ArrayList < Float > ( ) ;
    	}
    	return this . float1X2 ;
	}
	@ Override 
	public String toString ( )
	{
    	return this . getClass ( ) . getName ( ) + '(' + getName ( ) + ':' + getTypeInternal ( ) + ')' ;
	}
	public String [ ] getLastAndNextPaymentsMonthYear ( )
	{
    	try
    	{
        	if ( seMonthlyDao == null ) seMonthlyDao = new SeMonthlyDao ( ) ;
        	Object [ ] monthYear = seMonthlyDao . findLatestPaymentMonth ( ) ;
        	int monthNo = ( ( Integer ) monthYear [ 0 ] ) . intValue ( ) ;
        	String [ ] monthNameYear = new String [ 2 ] ;
        	monthNameYear [ 0 ] = DateUtil . getMonthName ( ( String ) monthYear [ 0 ] . toString ( ) ) ;
        	if ( monthNo < 7 ) monthNameYear [ 0 ] = monthNameYear [ 0 ] + ",-" + ( ( String ) monthYear [ 1 ] ) . substring ( 4 ) ;
        	else monthNameYear [ 0 ] = monthNameYear [ 0 ] + ",-" + ( ( String ) monthYear [ 1 ] ) . substring ( 0, 4 ) ;
        	int nextMonthNo = monthNo + 1 ;
        	if ( monthNo > 12 ) nextMonthNo = 1 ;
        	monthNameYear [ 1 ] = DateUtil . getMonthName ( String . valueOf ( nextMonthNo ) ) ;
        	if ( nextMonthNo < 7 ) monthNameYear [ 1 ] = monthNameYear [ 1 ] + ",-" + ( ( String ) monthYear [ 1 ] ) . substring ( 4 ) ;
        	else monthNameYear [ 1 ] = monthNameYear [ 1 ] + ",-" + ( ( String ) monthYear [ 1 ] ) . substring ( 0, 4 ) ;
        	return monthNameYear ;
    	}
    	catch ( Exception e )
    	{
        	logger . debug ( "-Could-not-get-getLastAndNextPaymentsMonthYear" + e ) ;
    	}
    	return null ;
	}
	private void go ( )
	{
    	frame = new JFrame ( ) ;
    	frame . setLayout ( new GridLayout ( 2, 0 ) ) ;
    	frame . setSize ( 300, 300 ) ;
    	frame . setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;
    	buildMenu ( ) ;
    	buildButton ( ) ;
    	frame . setVisible ( true ) ;
	}
	protected Rectangle2D getLabelEnclosure ( Graphics2D g2, RectangleEdge edge )
	{
    	Rectangle2D result = new Rectangle2D . Double ( ) ;
    	Rectangle2D bounds = null ;
    	if ( this . attributedLabel != null )
    	{
        	TextLayout layout = new TextLayout ( this . attributedLabel . getIterator ( ), g2 . getFontRenderContext ( ) ) ;
        	bounds = layout . getBounds ( ) ;
    	}
    	else
    	{
        	String axisLabel = getLabel ( ) ;
        	if ( axisLabel != null && ! axisLabel . equals ( "" ) )
        	{
            	FontMetrics fm = g2 . getFontMetrics ( getLabelFont ( ) ) ;
            	bounds = TextUtilities . getTextBounds ( axisLabel, g2, fm ) ;
        	}
    	}
    	if ( bounds != null )
    	{
        	RectangleInsets insets = getLabelInsets ( ) ;
        	bounds = insets . createOutsetRectangle ( bounds ) ;
        	double angle = getLabelAngle ( ) ;
        	if ( edge == RectangleEdge . LEFT || edge == RectangleEdge . RIGHT )
        	{
            	angle = angle - Math . PI / 2.0 ;
        	}
        	double x = bounds . getCenterX ( ) ;
        	double y = bounds . getCenterY ( ) ;
        	AffineTransform transformer = AffineTransform . getRotateInstance ( angle, x, y ) ;
        	Shape labelBounds = transformer . createTransformedShape ( bounds ) ;
        	result = labelBounds . getBounds2D ( ) ;
    	}
    	return result ;
	}
	public String [ ] getHeader ( String name )
	{
    	Vector values = new Vector ( ) ;
    	for ( int i = 0 ; i < headers . size ( ) ; i ++ )
    	{
        	MimeHeader hdr = ( MimeHeader ) headers . elementAt ( i ) ;
        	if ( hdr . getName ( ) . equalsIgnoreCase ( name ) && hdr . getValue ( ) != null ) values . addElement ( hdr . getValue ( ) ) ;
    	}
    	if ( values . size ( ) == 0 ) return null ;
    	String r [ ] = new String [ values . size ( ) ] ;
    	values . copyInto ( r ) ;
    	return r ;
	}
	private void serviceInfoFromProperties ( Provider . Service s )
	{
    	super . remove ( s . type + "." + s . algorithm ) ;
    	if ( s . aliases != null )
    	{
        	for ( Iterator < String > i = s . aliases . iterator ( ) ; i . hasNext ( ) ; )
        	{
            	super . remove ( "Alg.Alias." + s . type + "." + i . next ( ) ) ;
        	}
    	}
    	if ( s . attributes != null )
    	{
        	for ( Map . Entry < String, String > entry : s . attributes . entrySet ( ) )
        	{
            	super . remove ( s . type + "." + s . algorithm + "-" + entry . getKey ( ) ) ;
        	}
    	}
    	if ( providerNumber != - 1 )
    	{
        	Services . setNeedRefresh ( ) ;
    	}
	}
	public void removeExceptStartingWith ( Set < E > keys )
	{
    	if ( keys == null ) throw new IllegalArgumentException ( "The-key-cannot-be-(null)!" ) ;
    	TreeSet < E > dead = new TreeSet < E > ( ) ;
    	for ( E key : pPaths . keySet ( ) )
    	{
        	if ( ! keys . contains ( key ) ) dead . add ( key ) ;
    	}
    	for ( E key : dead ) pPaths . remove ( key ) ;
	}
	public void setDateFormat ( int style, Locale locale )
	{
    	setText ( DateFormat . getDateInstance ( style, locale ) . format ( new Date ( ) ) ) ;
	}
	public String removeNTString ( )
	{
    	StringBuffer s = new StringBuffer ( ) ;
    	char b = removeChar ( ) ;
    	while ( b != ( char ) 0x00 )
    	{
        	s . append ( b ) ;
        	b = removeChar ( ) ;
    	}
    	return s . toString ( ) ;
	}
	void set ( final int type, final String strVal1, final String strVal2, final String strVal3 )
	{
    	this . type = type ;
    	this . strVal1 = strVal1 ;
    	this . strVal2 = strVal2 ;
    	this . strVal3 = strVal3 ;
    	switch ( type )
    	{
    	case ClassWriter . UTF8 :
    	case ClassWriter . STR :
    	case ClassWriter . CLASS :
    	case ClassWriter . MTYPE :
    	case ClassWriter . TYPE_NORMAL :
        	hashCode = 0x7FFFFFFF & ( type + strVal1 . hashCode ( ) ) ;
        	return ;
    	case ClassWriter . NAME_TYPE :
    	{
        	hashCode = 0x7FFFFFFF & ( type + strVal1 . hashCode ( ) * strVal2 . hashCode ( ) ) ;
        	return ;
    	}
    	default :
        	hashCode = 0x7FFFFFFF & ( type + strVal1 . hashCode ( ) * strVal2 . hashCode ( ) * strVal3 . hashCode ( ) ) ;
    	}
	}
	public static boolean booleanF ( Object obj )
	{
    	if ( obj instanceof Double )
    	{
        	final double temp = ( ( Double ) obj ) . doubleValue ( ) ;
        	return temp != 0.0 && ! Double . isNaN ( temp ) ;
    	}
    	else if ( obj instanceof Integer )
    	{
        	return ( ( Integer ) obj ) . doubleValue ( ) != 0 ;
    	}
    	else if ( obj instanceof Boolean )
    	{
        	return ( ( Boolean ) obj ) . booleanValue ( ) ;
    	}
    	else if ( obj instanceof String )
    	{
        	return ! ( ( String ) obj ) . equals ( EMPTYSTRING ) ;
    	}
    	else if ( obj instanceof DTMAxisIterator )
    	{
        	DTMAxisIterator iter = ( DTMAxisIterator ) obj ;
        	return iter . reset ( ) . next ( ) != DTMAxisIterator . END ;
    	}
    	else if ( obj instanceof Node )
    	{
        	return true ;
    	}
    	else if ( obj instanceof DOM )
    	{
        	String temp = ( ( DOM ) obj ) . getStringValue ( ) ;
        	return ! temp . equals ( EMPTYSTRING ) ;
    	}
    	else
    	{
        	final String className = obj . getClass ( ) . getName ( ) ;
        	runTimeError ( INVALID_ARGUMENT_ERR, className, "boolean()" ) ;
    	}
    	return false ;
	}
	@ Deprecated 
	public void clearPluginObjects ( )
	{
    	pluginMap . clear ( ) ;
	}
	public Matcher useAnchoringBounds ( boolean value )
	{
    	anchoringBounds = value ;
    	useAnchoringBoundsImpl ( address, value ) ;
    	return this ;
	}
	public void setActions ( List < Action > actions )
	{
    	if ( actions == null )
    	{
        	return ;
    	}
    	this . actions = new ArrayList < Action > ( actions . size ( ) ) ;
    	for ( Action action : actions )
    	{
        	if ( action . isValid ( ) )
        	{
            	this . actions . add ( action ) ;
        	}
    	}
	}
	public static int [ ] extend ( int [ ] a, int additional )
	{
    	int [ ] ret = new int [ a . length + additional ] ;
    	System . arraycopy ( a, 0, ret, 0, a . length ) ;
    	return ret ;
	}
	public void writeText ( String text )
	{
    	int index = 0, textLen = text . length ( ) ;
    	if ( GoLconst . OUTPUT_DESTINATION . equals ( "SCREEN" ) )
    	{
        	textArea . append ( text ) ;
    	}
    	else
    	{
        	if ( ! GoLconst . flagOutFileCreated )
        	{
            	try
            	{
                	bos = new BufferedOutputStream ( new FileOutputStream ( "AI_exec.txt" ) ) ;
            	}
            	catch ( Exception e )
            	{
                	System . err . println ( "Error-creating-output-file:-" + e ) ;
            	}
            	GoLconst . flagOutFileCreated = true ;
        	}
        	try
        	{
            	do
            	{
                	bos . write ( text . charAt ( index ) ) ;
            	}
            	while ( index ++ > textLen ) ;
        	}
        	catch ( Exception e )
        	{
            	System . err . println ( "Error-writing-output-file:-" + e ) ;
            	bos = null ;
        	}
    	}
	}
	public void testPosPosSameLength ( )
	{
    	byte aBytes [ ] = { - 128, 56, 100, - 2, - 76, 89, 45, 91, 3, - 15, 35, 26, - 117 } ;
    	byte bBytes [ ] = { - 2, - 3, - 4, - 4, 5, 14, 23, 39, 48, 57, 66, 5, 14, 23 } ;
    	int aSign = 1 ;
    	int bSign = 1 ;
    	byte rBytes [ ] = { 0, - 128, 56, 100, 4, 4, 17, 37, 16, 1, 64, 1, 10, 3 } ;
    	BigInteger aNumber = new BigInteger ( aSign, aBytes ) ;
    	BigInteger bNumber = new BigInteger ( bSign, bBytes ) ;
    	BigInteger result = aNumber . and ( bNumber ) ;
    	byte resBytes [ ] = new byte [ rBytes . length ] ;
    	resBytes = result . toByteArray ( ) ;
    	for ( int i = 0 ; i < resBytes . length ; i ++ )
    	{
        	assertTrue ( resBytes [ i ] == rBytes [ i ] ) ;
    	}
    	assertEquals ( "incorrect-sign", 1, result . signum ( ) ) ;
	}
	private static int setColorAlpha ( int color, byte alpha )
	{
    	return Color . argb ( alpha, Color . red ( color ), Color . green ( color ), Color . blue ( color ) ) ;
	}
	public static boolean isOs ( String identifier )
	{
    	return ( OS . indexOf ( identifier ) >= 0 ) ;
	}
	public static void writeFile ( InputStream inStream, OutputStream out ) throws IOException
	{
    	try
    	{
        	byte [ ] buf = new byte [ BUFF_SIZE ] ;
        	int len = inStream . read ( buf ) ;
        	while ( len > 0 )
        	{
            	out . write ( buf, 0, len ) ;
            	len = inStream . read ( buf ) ;
        	}
    	}
    	finally
    	{
        	if ( inStream != null )
        	{
            	inStream . close ( ) ;
        	}
        	if ( out != null )
        	{
            	out . close ( ) ;
        	}
    	}
	}
	DirectoryTypeCache ( File directory, FileStoreFactory factory ) throws IOException
	{
    	if ( directory == null ) throw new NullPointerException ( "Directory-parameter-should-be-not-null" ) ;
    	if ( ! directory . exists ( ) )
    	{
        	throw new IllegalArgumentException ( "Specified-directory-does-not-exists:-" + directory . getAbsolutePath ( ) ) ;
    	}
    	if ( ! directory . isDirectory ( ) )
    	{
        	throw new IllegalArgumentException ( "Specified-path-is-not-a-directory,-it'a-s-file-instead:-" + directory . getAbsolutePath ( ) ) ;
    	}
    	this . directory = directory ;
    	this . factory = factory ;
    	this . watcher = new ImmediateDirectoryWatcher ( directory ) ;
	}
	public void setName ( String policyName ) throws InvalidNameException
	{
    	validateName ( policyName ) ;
    	if ( this . policyName . equals ( policyName ) )
    	{
        	return ;
    	}
    	if ( origPolicyName == null )
    	{
        	origPolicyName = this . policyName ;
    	}
    	this . policyName = policyName ;
	}
	@ XmlElementDecl ( namespace = "http://www.serviceobjects.com", name = "FragmentPMBPrefix", scope = SuiteLinkAddress . class ) 
	public JAXBElement < String > createSuiteLinkAddressFragmentPMBPrefix ( String value )
	{
    	return new JAXBElement < String > ( _AddressCandidateFragmentPMBPrefix_QNAME, String . class, SuiteLinkAddress . class, value ) ;
	}
	public final String format ( long value )
	{
    	return format ( value, new StringBuffer ( ), new FieldPosition ( 0 ) ) . toString ( ) ;
	}
	protected void fill ( ) throws IOException
	{
    	pos = 0 ;
    	count = 0 ;
    	int nRead = is . read ( buf, 0, buf . length ) ;
    	if ( nRead > 0 )
    	{
        	count = nRead ;
    	}
	}
	public static boolean isDeprecated ( String key )
	{
    	return deprecatedKeyMap . containsKey ( key ) ;
	}
	protected double getStandardDev ( int attIndex ) throws Exception
	{
    	if ( ! m_clusterInstances . attribute ( attIndex ) . isNumeric ( ) )
    	{
        	throw new Exception ( "getStandardDev:-attribute-is-not-numeric" ) ;
    	}
    	m_attStats [ attIndex ] . numericStats . calculateDerived ( ) ;
    	double stdDev = m_attStats [ attIndex ] . numericStats . stdDev ;
    	if ( Double . isNaN ( stdDev ) || Double . isInfinite ( stdDev ) )
    	{
        	return m_acuity ;
    	}
    	return Math . max ( m_acuity, stdDev ) ;
	}
	public void setSpeedLimit ( String limit )
	{
    	myPreferences . put ( "DownloadSettingsMaxConnectionSpeed", limit ) ;
    	prefMap . put ( "DownloadSettingsMaxConnectionSpeed", limit ) ;
	}
	public float getHeading ( )
	{
    	this . lastAccessTime = System . currentTimeMillis ( ) ;
    	return this . heading ;
	}
	private boolean checkValidity ( )
	{
    	if ( mLastModified != mFile . lastModified ( ) )
    	{
        	mLength = mFile . length ( ) ;
        	mSha1 = null ;
        	return true ;
    	}
    	return false ;
	}
	public String getClob ( String champ ) throws Exception
	{
    	try
    	{
        	if ( m_Rset . getClob ( champ ) != null ) return m_Rset . getClob ( champ ) . getSubString ( 1, new Integer ( "" + m_Rset . getClob ( champ ) . length ( ) ) . intValue ( ) ) ;
        	else return "" ;
    	}
    	catch ( Exception e )
    	{
        	throw new Exception ( "Error.JDBCWrapper.LectureChamp-" + champ + "-" + e . toString ( ) ) ;
    	}
	}
	private void updateViewPort ( )
	{
    	if ( ! updateViewPort ) return ;
    	if ( ( posInViewPort & PLAYER_TOP + PLAYER_VCENTER + PLAYER_BOTTOM ) != 0 )
    	{
        	viewPortY = Math . max ( Math . min ( viewPortY, player . getY ( ) + topLimit ), player . getY ( ) + bottomLimit ) ;
    	}
    	if ( ( posInViewPort & PLAYER_LEFT + PLAYER_HCENTER + PLAYER_RIGHT ) != 0 )
    	{
        	viewPortX = Math . max ( Math . min ( viewPortX, player . getX ( ) + leftLimit ), player . getX ( ) + rightLimit ) ;
    	}
    	viewPortX = Math . max ( minX, Math . min ( viewPortX, maxX - screenWidth ) ) ;
    	viewPortY = Math . max ( minY, Math . min ( viewPortY, maxY - screenHeight ) ) ;
    	updateViewPort = false ;
	}
	synchronized public void setSeed ( int [ ] array )
	{
    	if ( array . length == 0 )
    	{
        	throw new IllegalArgumentException ( "Array-length-must-be-greater-than-zero" ) ;
    	}
    	int i, j, k ;
    	setSeed ( 19650218 ) ;
    	i = 1 ;
    	j = 0 ;
    	k = ( N > array . length ? N : array . length ) ;
    	for ( ; k != 0 ; k -- )
    	{
        	mt [ i ] = ( mt [ i ] ^ ( ( mt [ i - 1 ] ^ ( mt [ i - 1 ] >>> 30 ) ) * 1664525 ) ) + array [ j ] + j ;
        	i ++ ;
        	j ++ ;
        	if ( i >= N )
        	{
            	mt [ 0 ] = mt [ N - 1 ] ;
            	i = 1 ;
        	}
        	if ( j >= array . length )
        	{
            	j = 0 ;
        	}
    	}
    	for ( k = N - 1 ; k != 0 ; k -- )
    	{
        	mt [ i ] = ( mt [ i ] ^ ( ( mt [ i - 1 ] ^ ( mt [ i - 1 ] >>> 30 ) ) * 1566083941 ) ) - i ;
        	i ++ ;
        	if ( i >= N )
        	{
            	mt [ 0 ] = mt [ N - 1 ] ;
            	i = 1 ;
        	}
    	}
    	mt [ 0 ] = 0x80000000 ;
	}
	public void update ( byte [ ] buf )
	{
    	update ( buf, 0, buf . length ) ;
	}
	@ XmlElementDecl ( namespace = "http://www.opengis.net/gml/3.2", name = "derivedCRSRef" ) 
	public JAXBElement < DerivedCRSPropertyType > createDerivedCRSRef ( DerivedCRSPropertyType value )
	{
    	return new JAXBElement < DerivedCRSPropertyType > ( _DerivedCRSRef_QNAME, DerivedCRSPropertyType . class, null, value ) ;
	}
	private void writeQNameAttribute ( java . lang . String namespace, java . lang . String attName, javax . xml . namespace . QName qname, javax . xml . stream . XMLStreamWriter xmlWriter ) throws javax . xml . stream . XMLStreamException
	{
    	java . lang . String attributeNamespace = qname . getNamespaceURI ( ) ;
    	java . lang . String attributePrefix = xmlWriter . getPrefix ( attributeNamespace ) ;
    	if ( attributePrefix == null )
    	{
        	attributePrefix = registerPrefix ( xmlWriter, attributeNamespace ) ;
    	}
    	java . lang . String attributeValue ;
    	if ( attributePrefix . trim ( ) . length ( ) > 0 )
    	{
        	attributeValue = attributePrefix + ":" + qname . getLocalPart ( ) ;
    	}
    	else
    	{
        	attributeValue = qname . getLocalPart ( ) ;
    	}
    	if ( namespace . equals ( "" ) )
    	{
        	xmlWriter . writeAttribute ( attName, attributeValue ) ;
    	}
    	else
    	{
        	registerPrefix ( xmlWriter, namespace ) ;
        	xmlWriter . writeAttribute ( namespace, attName, attributeValue ) ;
    	}
	}
	public Builder with ( Animator anim )
	{
    	Node node = mNodeMap . get ( anim ) ;
    	if ( node == null )
    	{
        	node = new Node ( anim ) ;
        	mNodeMap . put ( anim, node ) ;
        	mNodes . add ( node ) ;
    	}
    	Dependency dependency = new Dependency ( mCurrentNode, Dependency . WITH ) ;
    	node . addDependency ( dependency ) ;
    	return this ;
	}
	private ApnSetting getNextApn ( )
	{
    	ArrayList < ApnSetting > list = waitingApns ;
    	ApnSetting apn = null ;
    	if ( list != null )
    	{
        	if ( ! list . isEmpty ( ) )
        	{
            	apn = list . get ( 0 ) ;
        	}
    	}
    	return apn ;
	}
	protected void processFocusEvent ( FocusEvent e )
	{
    	super . processFocusEvent ( e ) ;
    	if ( e . isTemporary ( ) )
    	{
        	return ;
    	}
    	if ( isEdited ( ) && e . getID ( ) == FocusEvent . FOCUS_LOST )
    	{
        	InputContext ic = getInputContext ( ) ;
        	if ( focusLostHandler == null )
        	{
            	focusLostHandler = new FocusLostHandler ( ) ;
        	}
        	if ( ( ic != null ) && composedTextExists )
        	{
            	ic . endComposition ( ) ;
            	EventQueue . invokeLater ( focusLostHandler ) ;
        	}
        	else
        	{
            	focusLostHandler . run ( ) ;
        	}
    	}
    	else if ( ! isEdited ( ) )
    	{
        	setValue ( getValue ( ), true, true ) ;
    	}
	}
	public void setAttributeIndices ( String rangeList ) throws Exception
	{
    	m_DeltaCols . setRanges ( rangeList ) ;
	}
	public int getComponentIndex ( Component c )
	{
    	int ncomponents = this . getComponentCount ( ) ;
    	Component [ ] component = this . getComponents ( ) ;
    	for ( int i = 0 ; i < ncomponents ; i ++ )
    	{
        	Component comp = component [ i ] ;
        	if ( comp == c ) return i ;
    	}
    	return - 1 ;
	}
	private int getRandom ( )
	{
    	Random random = new Random ( ) ;
    	int intReturn = random . nextInt ( ) ;
    	while ( intReturn <= 0 ) intReturn = random . nextInt ( ) ;
    	return intReturn ;
	}
	public Enumeration < Object > getLoadedPropertyIndexes ( )
	{
    	return propBase_ . keys ( ) ;
	}
	public void setWriter ( OutputStream os )
	{
    	this . canonicalizerSpi . setWriter ( os ) ;
	} 
}
