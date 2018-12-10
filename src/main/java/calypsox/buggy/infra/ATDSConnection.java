package calypsox.buggy.infra;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Collection;
import java.util.List;

import com.calypso.infra.authentication.context.rmi.ContextPropagatingRemoteInvocationFactory;
import com.calypso.infra.authentication.userdetails.CalypsoUserDetails;
import com.calypso.infra.rmi.RMIProxyProperties;
import com.calypso.tk.core.Book;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.refdata.AccessUtil;
import com.calypso.tk.refdata.User;
import com.calypso.tk.refdata.UserDefaults;
import com.calypso.tk.service.ConnectionListener;
import com.calypso.tk.service.DSConnection;
import com.calypso.tk.service.RemoteAccess;
import com.calypso.tk.service.RemoteAccounting;
import com.calypso.tk.service.RemoteBackOffice;
import com.calypso.tk.service.RemoteCommodity;
import com.calypso.tk.service.RemoteFXDataServer;
import com.calypso.tk.service.RemoteMark;
import com.calypso.tk.service.RemoteMarketData;
import com.calypso.tk.service.RemoteProduct;
import com.calypso.tk.service.RemoteReferenceData;
import com.calypso.tk.service.RemoteTrade;
import com.calypso.tk.util.ConnectException;
import com.calypso.tk.util.VersionMismatchException;

import calypsox.buggy.uti.CalypsoEnvironment;

/**
 * The Class ATDSConnection. Used to simulate a DSConnection with a different
 * user
 */
public class ATDSConnection extends DSConnection {

    /** The alternative user. */
    private String alternativeUser;

    /**
     * Instantiates a new AATDS connection.
     *
     * @param userName the user name
     */
    public ATDSConnection(final String userName) {
	alternativeUser = userName;
	DSConnection.setDefault(this);
	AccessUtil.reloadUserAccess();
    }

    /**
     * Restore real connection.
     */
    public void restoreRealConnection() {
	alternativeUser = null;
	DSConnection.setDefault(CalypsoEnvironment.getInstance().getDSConnection());
	AccessUtil.reloadUserAccess();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getUser()
     */
    @Override
    public String getUser() {
	if (alternativeUser == null) {
	    return CalypsoEnvironment.getInstance().getDSConnection().getUser();
	}
	return alternativeUser;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteAccess()
     */
    @Override
    public RemoteAccess getRemoteAccess() {
	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteAccess();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteTrade()
     */
    @Override
    public RemoteTrade getRemoteTrade() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteTrade();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteBackOffice()
     */
    @Override
    public RemoteBackOffice getRemoteBackOffice() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteBackOffice();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteBO()
     */
    @Override
    public RemoteBackOffice getRemoteBO() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteBO();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteReferenceData()
     */
    @Override
    public RemoteReferenceData getRemoteReferenceData() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteReferenceData();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteAccounting()
     */
    @Override
    public RemoteAccounting getRemoteAccounting() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteAccounting();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteProduct()
     */
    @Override
    public RemoteProduct getRemoteProduct() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteProduct();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteMarketData()
     */
    @Override
    public RemoteMarketData getRemoteMarketData() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteMarketData();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteFXDataServer()
     */
    @Override
    public RemoteFXDataServer getRemoteFXDataServer() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteFXDataServer();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteCommodity()
     */
    @Override
    public RemoteCommodity getRemoteCommodity() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteCommodity();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#init()
     */
    @Override
    public void init() throws ConnectException {

	CalypsoEnvironment.getInstance().getDSConnection().init();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#start()
     */
    @Override
    public void start() throws ConnectException {

	CalypsoEnvironment.getInstance().getDSConnection().start();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#initRWROServerProperties()
     */
    @Override
    public void initRWROServerProperties() {

	CalypsoEnvironment.getInstance().getDSConnection().initRWROServerProperties();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getUserInfo()
     */
    @Override
    public User getUserInfo() {

	return CalypsoEnvironment.getInstance().getDSConnection().getUserInfo();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getHostName()
     */
    @Override
    public String getHostName() {

	return CalypsoEnvironment.getInstance().getDSConnection().getHostName();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getDataServerName()
     */
    @Override
    public String getDataServerName() {

	return CalypsoEnvironment.getInstance().getDSConnection().getDataServerName();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getUserDefaults(java.lang.String)
     */
    @Override
    public UserDefaults getUserDefaults(final String userName) {

	return CalypsoEnvironment.getInstance().getDSConnection().getUserDefaults(userName);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#displayClientStarted()
     */
    @Override
    public void displayClientStarted() {

	CalypsoEnvironment.getInstance().getDSConnection().displayClientStarted();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#localPort()
     */
    @Override
    public int localPort() {

	return CalypsoEnvironment.getInstance().getDSConnection().localPort();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#checkVersion()
     */
    @Override
    public void checkVersion() throws VersionMismatchException {

	CalypsoEnvironment.getInstance().getDSConnection().checkVersion();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getLocal()
     */
    @Override
    public boolean getLocal() {

	return CalypsoEnvironment.getInstance().getDSConnection().getLocal();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#refreshHolidays()
     */
    @Override
    public void refreshHolidays() {

	CalypsoEnvironment.getInstance().getDSConnection().refreshHolidays();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#refreshCurrencyUtil()
     */
    @Override
    public void refreshCurrencyUtil() {

	CalypsoEnvironment.getInstance().getDSConnection().refreshCurrencyUtil();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#refreshMimeTypes()
     */
    @Override
    public void refreshMimeTypes() {

	CalypsoEnvironment.getInstance().getDSConnection().refreshMimeTypes();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#reconnect()
     */
    @Override
    public void reconnect() throws ConnectException {

	CalypsoEnvironment.getInstance().getDSConnection().reconnect();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getListeners()
     */
    @Override
    public List<ConnectionListener> getListeners() {

	return CalypsoEnvironment.getInstance().getDSConnection().getListeners();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#addListener(com.calypso.tk.service.
     * ConnectionListener)
     */
    @Override
    public void addListener(final ConnectionListener l) {

	CalypsoEnvironment.getInstance().getDSConnection().addListener(l);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.calypso.tk.service.DSConnection#removeListener(com.calypso.tk.service.
     * ConnectionListener)
     */
    @Override
    public void removeListener(final ConnectionListener l) {

	CalypsoEnvironment.getInstance().getDSConnection().removeListener(l);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#notifyReconnect()
     */
    @Override
    public void notifyReconnect() {

	CalypsoEnvironment.getInstance().getDSConnection().notifyReconnect();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#notifyConnectionFailure()
     */
    @Override
    public void notifyConnectionFailure() {

	CalypsoEnvironment.getInstance().getDSConnection().notifyConnectionFailure();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getDefaultCurrency()
     */
    @Override
    public String getDefaultCurrency() {

	return CalypsoEnvironment.getInstance().getDSConnection().getDefaultCurrency();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getDefaultBook()
     */
    @Override
    public Book getDefaultBook() {

	return CalypsoEnvironment.getInstance().getDSConnection().getDefaultBook();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getDefaultTradeFilter()
     */
    @Override
    public String getDefaultTradeFilter() {

	return CalypsoEnvironment.getInstance().getDSConnection().getDefaultTradeFilter();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getDefaultPricingEnv()
     */
    @Override
    public String getDefaultPricingEnv() {

	return CalypsoEnvironment.getInstance().getDSConnection().getDefaultPricingEnv();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.calypso.tk.service.DSConnection#changePassword(com.calypso.tk.refdata.
     * User, java.lang.String)
     */
    @Override
    public void changePassword(final User usero, final String newp) {

	CalypsoEnvironment.getInstance().getDSConnection().changePassword(usero, newp);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getServerCurrentDatetime()
     */
    @Override
    public JDatetime getServerCurrentDatetime() {

	return CalypsoEnvironment.getInstance().getDSConnection().getServerCurrentDatetime();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRMIService(java.lang.String,
     * java.lang.Class)
     */
    @Override
    public <T> T getRMIService(final String serviceName, final Class<T> serviceInterface) {

	return CalypsoEnvironment.getInstance().getDSConnection().getRMIService(serviceName, serviceInterface);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#setApplicationName(java.lang.String)
     */
    @Override
    public void setApplicationName(final String appName) throws IOException {

	CalypsoEnvironment.getInstance().getDSConnection().setApplicationName(appName);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.calypso.tk.service.DSConnection#isApplicationRunning(java.lang.String)
     */
    @Override
    public boolean isApplicationRunning(final String appName) throws RemoteException {

	return CalypsoEnvironment.getInstance().getDSConnection().isApplicationRunning(appName);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getConnectedClients()
     */
    @Override
    public Collection<CalypsoUserDetails> getConnectedClients() throws RemoteException {

	return CalypsoEnvironment.getInstance().getDSConnection().getConnectedClients();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getApplicationNames()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Collection getApplicationNames() throws RemoteException {

	return CalypsoEnvironment.getInstance().getDSConnection().getApplicationNames();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getAppName()
     */
    @Override
    public String getAppName() {

	return CalypsoEnvironment.getInstance().getDSConnection().getAppName();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getReadOnlyConnection()
     */
    @Override
    public DSConnection getReadOnlyConnection() throws ConnectException {

	return CalypsoEnvironment.getInstance().getDSConnection().getReadOnlyConnection();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getReadOnlyConnection(boolean)
     */
    @Override
    public DSConnection getReadOnlyConnection(final boolean useRWDSIfNoRODS) throws ConnectException {

	return CalypsoEnvironment.getInstance().getDSConnection().getReadOnlyConnection(useRWDSIfNoRODS);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#refreshUserDefaults()
     */
    @Override
    public void refreshUserDefaults() {

	CalypsoEnvironment.getInstance().getDSConnection().refreshUserDefaults();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#isReadOnly()
     */
    @Override
    public boolean isReadOnly() {

	return CalypsoEnvironment.getInstance().getDSConnection().isReadOnly();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getReadWriteConnection()
     */
    @Override
    public DSConnection getReadWriteConnection() throws ConnectException {

	return CalypsoEnvironment.getInstance().getDSConnection().getReadWriteConnection();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.tk.service.DSConnection#getRemoteMark()
     */
    @Override
    public RemoteMark getRemoteMark() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteMark();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.infra.rmi.BaseServerConnection#getInstanceName()
     */
    @Override
    public String getInstanceName() {

	return CalypsoEnvironment.getInstance().getDSConnection().getInstanceName();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.infra.rmi.BaseServerConnection#getRemoteInvocationFactory()
     */
    @Override
    public ContextPropagatingRemoteInvocationFactory getRemoteInvocationFactory() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRemoteInvocationFactory();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.infra.rmi.BaseServerConnection#getRmiProxyProps()
     */
    @Override
    public RMIProxyProperties getRmiProxyProps() {

	return CalypsoEnvironment.getInstance().getDSConnection().getRmiProxyProps();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.infra.rmi.BaseServerConnection#getService(java.lang.Class)
     */
    @Override
    public <T> T getService(final Class<T> arg0) {

	return CalypsoEnvironment.getInstance().getDSConnection().getService(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.infra.rmi.BaseServerConnection#getServiceURL()
     */
    @Override
    public String getServiceURL() {

	return CalypsoEnvironment.getInstance().getDSConnection().getServiceURL();
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.infra.rmi.BaseServerConnection#isServer()
     */
    @Override
    public boolean isServer() {

	return CalypsoEnvironment.getInstance().getDSConnection().isServer();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.calypso.infra.rmi.BaseServerConnection#setInstanceName(java.lang.String)
     */
    @Override
    public void setInstanceName(final String arg0) {

	CalypsoEnvironment.getInstance().getDSConnection().setInstanceName(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.calypso.infra.rmi.BaseServerConnection#setRemoteInvocationFactory(com.
     * calypso.infra.authentication.context.rmi.
     * ContextPropagatingRemoteInvocationFactory)
     */
    @Override
    public void setRemoteInvocationFactory(final ContextPropagatingRemoteInvocationFactory arg0) {

	CalypsoEnvironment.getInstance().getDSConnection().setRemoteInvocationFactory(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.calypso.infra.rmi.BaseServerConnection#setRmiProxyProps(com.calypso.infra
     * .rmi.RMIProxyProperties)
     */
    @Override
    public void setRmiProxyProps(final RMIProxyProperties arg0) {

	CalypsoEnvironment.getInstance().getDSConnection().setRmiProxyProps(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.calypso.infra.rmi.BaseServerConnection#setServer(boolean)
     */
    @Override
    public void setServer(final boolean arg0) {

	CalypsoEnvironment.getInstance().getDSConnection().setServer(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.calypso.infra.rmi.BaseServerConnection#setServiceURL(java.lang.String)
     */
    @Override
    public void setServiceURL(final String arg0) {

	CalypsoEnvironment.getInstance().getDSConnection().setServiceURL(arg0);
    }

}
