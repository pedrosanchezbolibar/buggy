package calypsox.buggy.refdata;

import java.util.List;

import com.calypso.tk.core.CalypsoServiceException;
import com.calypso.tk.core.DateRoll;
import com.calypso.tk.core.DateRule;
import com.calypso.tk.core.Frequency;
import com.calypso.tk.core.GDIdentifiers;
import com.calypso.tk.core.JDate;
import com.calypso.tk.core.JDatetime;
import com.calypso.tk.refdata.Account;
import com.calypso.tk.refdata.AccountConsolidationConfig;
import com.calypso.tk.refdata.AccountLimit;
import com.calypso.tk.refdata.CustodyTaxLotLiquidationMethod;
import com.calypso.tk.service.DSConnection;

import calypsox.buggy.product.ATTrade;

/**
 * The Class ATAccount.
 */
public class ATAccount {

    /** The account. */
    private final Account account;

    /**
     * Instantiates a new AT account.
     *
     * @param accountId
     *            the account id
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATAccount(final int accountId) throws CalypsoServiceException {
        account = DSConnection.getDefault().getRemoteAccounting().getAccount(accountId);
    }

    /**
     * Gets the acc engine only B.
     *
     * @return the acc engine only B
     */
    public boolean getAccEngineOnlyB() {
        return account.getAccEngineOnlyB();
    }

    /**
     * Gets the access pct.
     *
     * @return the access pct
     */
    public double getAccessPct() {
        return account.getAccessPct();
    }

    /**
     * Gets the account consolidation config.
     *
     * @return the account consolidation config
     */
    public AccountConsolidationConfig getAccountConsolidationConfig() {
        return account.getAccountConsolidationConfig();
    }

    /**
     * Gets the account holder role.
     *
     * @return the account holder role
     */
    public String getAccountHolderRole() {
        return Account.getAccountHolderRole();
    }

    /**
     * Gets the account holder SDI contact.
     *
     * @return the account holder SDI contact
     */
    public String getAccountHolderSDIContact() {
        return Account.getAccountHolderSDIContact();
    }

    /**
     * Gets the account interests.
     *
     * @return the account interests
     */
    public List getAccountInterests() {
        return account.getAccountInterests();
    }

    /**
     * Gets the account limits.
     *
     * @return the account limits
     */
    public List getAccountLimits() {
        return account.getAccountLimits();
    }

    /**
     * Gets the account properties.
     *
     * @return the account properties
     */
    public List getAccountProperties() {
        return account.getAccountProperties();
    }

    /**
     * Gets the account settle method.
     *
     * @return the account settle method
     */
    public String getAccountSettleMethod() {
        return Account.getAccountSettleMethod();
    }

    /**
     * Gets the account status.
     *
     * @return the account status
     */
    public String getAccountStatus() {
        return account.getAccountStatus();
    }

    /**
     * Gets the account sub type.
     *
     * @return the account sub type
     */
    public String getAccountSubType() {
        return account.getAccountSubType();
    }

    /**
     * Gets the account sub type domain.
     *
     * @return the account sub type domain
     */
    public List getAccountSubTypeDomain() {
        return Account.getAccountSubTypeDomain();
    }

    /**
     * Gets the account type.
     *
     * @return the account type
     */
    public String getAccountType() {
        return account.getAccountType();
    }

    /**
     * Gets the active from.
     *
     * @return the active from
     */
    public JDate getActiveFrom() {
        return account.getActiveFrom();
    }

    /**
     * Gets the active to.
     *
     * @return the active to
     */
    public JDate getActiveTo() {
        return account.getActiveTo();
    }

    /**
     * Gets the aggregation type.
     *
     * @return the aggregation type
     */
    public String getAggregationType() {
        return account.getAggregationType();
    }

    /**
     * Gets the allocated seed.
     *
     * @return the allocated seed
     */
    public int getAllocatedSeed() {
        return account.getAllocatedSeed();
    }

    /**
     * Gets the archived B.
     *
     * @return the archived B
     */
    public boolean getArchivedB() {
        return account.getArchivedB();
    }

    /**
     * Gets the attributes.
     *
     * @return the attributes
     */
    public List getAttributes() {
        return account.getAttributes();
    }

    /**
     * Gets the auth name.
     *
     * @return the auth name
     */
    public String getAuthName() {
        return account.getAuthName();
    }

    /**
     * Gets the automatic B.
     *
     * @return the automatic B
     */
    public boolean getAutomaticB() {
        return account.getAutomaticB();
    }

    /**
     * Gets the balance B.
     *
     * @return the balance B
     */
    public boolean getBalanceB() {
        return account.getBalanceB();
    }

    /**
     * Gets the balance date roll.
     *
     * @return the balance date roll
     */
    public DateRoll getBalanceDateRoll() {
        return account.getBalanceDateRoll();
    }

    /**
     * Gets the balance date rule.
     *
     * @return the balance date rule
     */
    public DateRule getBalanceDateRule() {
        return account.getBalanceDateRule();
    }

    /**
     * Gets the balance day.
     *
     * @return the balance day
     */
    public int getBalanceDay() {
        return account.getBalanceDay();
    }

    /**
     * Gets the balance frequency.
     *
     * @return the balance frequency
     */
    public Frequency getBalanceFrequency() {
        return account.getBalanceFrequency();
    }

    /**
     * Gets the billing B.
     *
     * @return the billing B
     */
    public boolean getBillingB() {
        return account.getBillingB();
    }

    /**
     * Gets the call account B.
     *
     * @return the call account B
     */
    public boolean getCallAccountB() {
        return account.getCallAccountB();
    }

    /**
     * Gets the call account sub type.
     *
     * @return the call account sub type
     */
    public String getCallAccountSubType() {
        return account.getCallAccountSubType();
    }

    /**
     * Gets the call account type.
     *
     * @return the call account type
     */
    public String getCallAccountType() {
        return account.getCallAccountType();
    }

    /**
     * Gets the call book id.
     *
     * @return the call book id
     */
    public int getCallBookId() {
        return account.getCallBookId();
    }

    /**
     * Gets the capitalize ib on source B.
     *
     * @return the capitalize ib on source B
     */
    public boolean getCapitalizeIbOnSourceB() {
        return account.getCapitalizeIbOnSourceB();
    }

    /**
     * Gets the closing account id.
     *
     * @return the closing account id
     */
    public int getClosingAccountId() {
        return account.getClosingAccountId();
    }

    /**
     * Gets the creation date.
     *
     * @return the creation date
     */
    public JDatetime getCreationDate() {
        return account.getCreationDate();
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return account.getCurrency();
    }

    /**
     * Gets the custody call account mirroring optional flag.
     *
     * @return the custody call account mirroring optional flag
     */
    public boolean getCustodyCallAccountMirroringOptionalFlag() {
        return Account.getCustodyCallAccountMirroringOptionalFlag();
    }

    /**
     * Gets the custody tax method.
     *
     * @return the custody tax method
     */
    public CustodyTaxLotLiquidationMethod getCustodyTaxMethod() {
        return account.getCustodyTaxMethod();
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return account.getDescription();
    }

    /**
     * Gets the destination account id.
     *
     * @return the destination account id
     */
    public int getDestinationAccountId() {
        return account.getDestinationAccountId();
    }

    /**
     * Gets the dormant date.
     *
     * @return the dormant date
     */
    public JDate getDormantDate() {
        return account.getDormantDate();
    }

    /**
     * Gets the external name.
     *
     * @return the external name
     */
    public String getExternalName() {
        return account.getExternalName();
    }

    /**
     * Gets the global deployment identifiers.
     *
     * @return the global deployment identifiers
     */
    public GDIdentifiers getGlobalDeploymentIdentifiers() {
        return account.getGlobalDeploymentIdentifiers();
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return account.getId();
    }

    /**
     * Gets the instant access.
     *
     * @return the instant access
     */
    public double getInstantAccess() {
        return account.getInstantAccess();
    }

    /**
     * Gets the interest bearing B.
     *
     * @return the interest bearing B
     */
    public boolean getInterestBearingB() {
        return account.getInterestBearingB();
    }

    /**
     * Gets the interest bearing quick entry B.
     *
     * @return the interest bearing quick entry B
     */
    public boolean getInterestBearingQuickEntryB() {
        return account.getInterestBearingQuickEntryB();
    }

    /**
     * Gets the interface rule.
     *
     * @return the interface rule
     */
    public String getInterfaceRule() {
        return account.getInterfaceRule();
    }

    /**
     * Gets the checks if is by trade date.
     *
     * @return the checks if is by trade date
     */
    public boolean getIsByTradeDate() {
        return account.getIsByTradeDate();
    }

    /**
     * Gets the last closing date.
     *
     * @return the last closing date
     */
    public JDatetime getLastClosingDate() {
        return account.getLastClosingDate();
    }

    /**
     * Gets the last limit.
     *
     * @return the last limit
     */
    public AccountLimit getLastLimit() {
        return account.getLastLimit();
    }

    /**
     * Gets the last mvt date.
     *
     * @return the last mvt date
     */
    public JDate getLastMvtDate() {
        return account.getLastMvtDate();
    }

    /**
     * Gets the last review date.
     *
     * @return the last review date
     */
    public JDate getLastReviewDate() {
        return account.getLastReviewDate();
    }

    /**
     * Gets the legal entity.
     *
     * @return the legal entity
     */
    public ATLegalEntity getLegalEntity() {
        return new ATLegalEntity(account.getLegalEntityId());
    }

    /**
     * Gets the legal entity role.
     *
     * @return the legal entity role
     */
    public String getLegalEntityRole() {
        return account.getLegalEntityRole();
    }

    /**
     * Gets the limit B.
     *
     * @return the limit B
     */
    public boolean getLimitB() {
        return account.getLimitB();
    }

    /**
     * Gets the limit review date rule.
     *
     * @return the limit review date rule
     */
    public DateRule getLimitReviewDateRule() {
        return account.getLimitReviewDateRule();
    }

    /**
     * Gets the margin quick entry B.
     *
     * @return the margin quick entry B
     */
    public boolean getMarginQuickEntryB() {
        return account.getMarginQuickEntryB();
    }

    /**
     * Gets the master account id.
     *
     * @return the master account id
     */
    public int getMasterAccountId() {
        return account.getMasterAccountId();
    }

    /**
     * Gets the master B.
     *
     * @return the master B
     */
    public boolean getMasterB() {
        return account.getMasterB();
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return account.getName();
    }

    /**
     * Gets the notice days.
     *
     * @return the notice days
     */
    public int getNoticeDays() {
        return account.getNoticeDays();
    }

    /**
     * Gets the offsetting excluded event types.
     *
     * @return the offsetting excluded event types
     */
    public List getOffsettingExcludedEventTypes() {
        return account.getOffsettingExcludedEventTypes();
    }

    /**
     * Gets the original account id.
     *
     * @return the original account id
     */
    public int getOriginalAccountId() {
        return account.getOriginalAccountId();
    }

    /**
     * Gets the parent account id.
     *
     * @return the parent account id
     */
    public int getParentAccountId() {
        return account.getParentAccountId();
    }

    /**
     * Gets the pay out externally B.
     *
     * @return the pay out externally B
     */
    public boolean getPayOutExternallyB() {
        return account.getPayOutExternallyB();
    }

    /**
     * Gets the processing org based id.
     *
     * @return the processing org based id
     */
    public int getProcessingOrgBasedId() {
        return account.getProcessingOrgBasedId();
    }

    /**
     * Gets the processing org id.
     *
     * @return the processing org id
     */
    public ATLegalEntity getProcessingOrgId() {
        return new ATLegalEntity(account.getProcessingOrgId());
    }

    /**
     * Gets the product template.
     *
     * @return the product template
     */
    public String getProductTemplate() {
        return account.getProductTemplate();
    }

    /**
     * Gets the proprietary account id.
     *
     * @return the proprietary account id
     */
    public int getProprietaryAccountId() {
        return account.getProprietaryAccountId();
    }

    /**
     * Gets the proprietary B.
     *
     * @return the proprietary B
     */
    public boolean getProprietaryB() {
        return account.getProprietaryB();
    }

    /**
     * Gets the reactivation date.
     *
     * @return the reactivation date
     */
    public JDate getReactivationDate() {
        return account.getReactivationDate();
    }

    /**
     * Gets the retroactivity date rule.
     *
     * @return the retroactivity date rule
     */
    public DateRule getRetroactivityDateRule() {
        return account.getRetroactivityDateRule();
    }

    /**
     * Gets the seed for call account.
     *
     * @return the seed for call account
     */
    public String getSeedForCallAccount() {
        return Account.getSeedForCallAccount();
    }

    /**
     * Gets the split xfer adj int B.
     *
     * @return the split xfer adj int B
     */
    public boolean getSplitXferAdjIntB() {
        return account.getSplitXferAdjIntB();
    }

    /**
     * Gets the split xfer pay rec B.
     *
     * @return the split xfer pay rec B
     */
    public boolean getSplitXferPayRecB() {
        return account.getSplitXferPayRecB();
    }

    /**
     * Gets the statement B.
     *
     * @return the statement B
     */
    public boolean getStatementB() {
        return account.getStatementB();
    }

    /**
     * Gets the statement configs.
     *
     * @return the statement configs
     */
    public List getStatementConfigs() {
        return account.getStatementConfigs();
    }

    /**
     * Gets the sub account type.
     *
     * @return the sub account type
     */
    public String getSubAccountType() {
        return account.getSubAccountType();
    }

    /**
     * Gets the swinging B.
     *
     * @return the swinging B
     */
    public boolean getSwingingB() {
        return account.getSwingingB();
    }

    /**
     * Gets the tax lot method.
     *
     * @return the tax lot method
     */
    public String getTaxLotMethod() {
        return account.getTaxLotMethod();
    }

    /**
     * Gets the total balance.
     *
     * @return the total balance
     */
    public double getTotalBalance() {
        return account.getTotalBalance();
    }

    /**
     * Gets the trade.
     *
     * @return the trade
     * @throws CalypsoServiceException
     *             the calypso service exception
     */
    public ATTrade getTrade() throws CalypsoServiceException {
        return new ATTrade(account.getTradeId());
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public String getUser() {
        return account.getUser();
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public int getVersion() {
        return account.getVersion();
    }

}
