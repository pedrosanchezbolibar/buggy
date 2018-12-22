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

public class ATAccount {

    Account account;

    public ATAccount(final int accountId) throws CalypsoServiceException {
        account = DSConnection.getDefault().getRemoteAccounting().getAccount(accountId);
    }

    public boolean getAccEngineOnlyB() {
        return account.getAccEngineOnlyB();
    }

    public double getAccessPct() {
        return account.getAccessPct();
    }

    public AccountConsolidationConfig getAccountConsolidationConfig() {
        return account.getAccountConsolidationConfig();
    }

    public String getAccountHolderRole() {
        return Account.getAccountHolderRole();
    }

    public String getAccountHolderSDIContact() {
        return Account.getAccountHolderSDIContact();
    }

    public List getAccountInterests() {
        return account.getAccountInterests();
    }

    public List getAccountLimits() {
        return account.getAccountLimits();
    }

    public List getAccountProperties() {
        return account.getAccountProperties();
    }

    public String getAccountSettleMethod() {
        return Account.getAccountSettleMethod();
    }

    public String getAccountStatus() {
        return account.getAccountStatus();
    }

    public String getAccountSubType() {
        return account.getAccountSubType();
    }

    public List getAccountSubTypeDomain() {
        return Account.getAccountSubTypeDomain();
    }

    public String getAccountType() {
        return account.getAccountType();
    }

    public JDate getActiveFrom() {
        return account.getActiveFrom();
    }

    public JDate getActiveTo() {
        return account.getActiveTo();
    }

    public String getAggregationType() {
        return account.getAggregationType();
    }

    public int getAllocatedSeed() {
        return account.getAllocatedSeed();
    }

    public boolean getArchivedB() {
        return account.getArchivedB();
    }

    public List getAttributes() {
        return account.getAttributes();
    }

    public String getAuthName() {
        return account.getAuthName();
    }

    public boolean getAutomaticB() {
        return account.getAutomaticB();
    }

    public boolean getBalanceB() {
        return account.getBalanceB();
    }

    public DateRoll getBalanceDateRoll() {
        return account.getBalanceDateRoll();
    }

    public DateRule getBalanceDateRule() {
        return account.getBalanceDateRule();
    }

    public int getBalanceDay() {
        return account.getBalanceDay();
    }

    public Frequency getBalanceFrequency() {
        return account.getBalanceFrequency();
    }

    public boolean getBillingB() {
        return account.getBillingB();
    }

    public boolean getCallAccountB() {
        return account.getCallAccountB();
    }

    public String getCallAccountSubType() {
        return account.getCallAccountSubType();
    }

    public String getCallAccountType() {
        return account.getCallAccountType();
    }

    public int getCallBookId() {
        return account.getCallBookId();
    }

    public boolean getCapitalizeIbOnSourceB() {
        return account.getCapitalizeIbOnSourceB();
    }

    public int getClosingAccountId() {
        return account.getClosingAccountId();
    }

    public JDatetime getCreationDate() {
        return account.getCreationDate();
    }

    public String getCurrency() {
        return account.getCurrency();
    }

    public boolean getCustodyCallAccountMirroringOptionalFlag() {
        return Account.getCustodyCallAccountMirroringOptionalFlag();
    }

    public CustodyTaxLotLiquidationMethod getCustodyTaxMethod() {
        return account.getCustodyTaxMethod();
    }

    public String getDescription() {
        return account.getDescription();
    }

    public int getDestinationAccountId() {
        return account.getDestinationAccountId();
    }

    public JDate getDormantDate() {
        return account.getDormantDate();
    }

    public String getExternalName() {
        return account.getExternalName();
    }

    public GDIdentifiers getGlobalDeploymentIdentifiers() {
        return account.getGlobalDeploymentIdentifiers();
    }

    public int getId() {
        return account.getId();
    }

    public double getInstantAccess() {
        return account.getInstantAccess();
    }

    public boolean getInterestBearingB() {
        return account.getInterestBearingB();
    }

    public boolean getInterestBearingQuickEntryB() {
        return account.getInterestBearingQuickEntryB();
    }

    public String getInterfaceRule() {
        return account.getInterfaceRule();
    }

    public boolean getIsByTradeDate() {
        return account.getIsByTradeDate();
    }

    public JDatetime getLastClosingDate() {
        return account.getLastClosingDate();
    }

    public AccountLimit getLastLimit() {
        return account.getLastLimit();
    }

    public JDate getLastMvtDate() {
        return account.getLastMvtDate();
    }

    public JDate getLastReviewDate() {
        return account.getLastReviewDate();
    }

    public ATLegalEntity getLegalEntity() {
        return new ATLegalEntity(account.getLegalEntityId());
    }

    public String getLegalEntityRole() {
        return account.getLegalEntityRole();
    }

    public boolean getLimitB() {
        return account.getLimitB();
    }

    public DateRule getLimitReviewDateRule() {
        return account.getLimitReviewDateRule();
    }

    public boolean getMarginQuickEntryB() {
        return account.getMarginQuickEntryB();
    }

    public int getMasterAccountId() {
        return account.getMasterAccountId();
    }

    public boolean getMasterB() {
        return account.getMasterB();
    }

    public String getName() {
        return account.getName();
    }

    public int getNoticeDays() {
        return account.getNoticeDays();
    }

    public List getOffsettingExcludedEventTypes() {
        return account.getOffsettingExcludedEventTypes();
    }

    public int getOriginalAccountId() {
        return account.getOriginalAccountId();
    }

    public int getParentAccountId() {
        return account.getParentAccountId();
    }

    public boolean getPayOutExternallyB() {
        return account.getPayOutExternallyB();
    }

    public int getProcessingOrgBasedId() {
        return account.getProcessingOrgBasedId();
    }

    public ATLegalEntity getProcessingOrgId() {
        return new ATLegalEntity(account.getProcessingOrgId());
    }

    public String getProductTemplate() {
        return account.getProductTemplate();
    }

    public int getProprietaryAccountId() {
        return account.getProprietaryAccountId();
    }

    public boolean getProprietaryB() {
        return account.getProprietaryB();
    }

    public JDate getReactivationDate() {
        return account.getReactivationDate();
    }

    public DateRule getRetroactivityDateRule() {
        return account.getRetroactivityDateRule();
    }

    public String getSeedForCallAccount() {
        return Account.getSeedForCallAccount();
    }

    public boolean getSplitXferAdjIntB() {
        return account.getSplitXferAdjIntB();
    }

    public boolean getSplitXferPayRecB() {
        return account.getSplitXferPayRecB();
    }

    public boolean getStatementB() {
        return account.getStatementB();
    }

    public List getStatementConfigs() {
        return account.getStatementConfigs();
    }

    public String getSubAccountType() {
        return account.getSubAccountType();
    }

    public boolean getSwingingB() {
        return account.getSwingingB();
    }

    public String getTaxLotMethod() {
        return account.getTaxLotMethod();
    }

    public double getTotalBalance() {
        return account.getTotalBalance();
    }

    public ATTrade getTrade() throws CalypsoServiceException {
        return new ATTrade(account.getTradeId());
    }

    public String getUser() {
        return account.getUser();
    }

    public int getVersion() {
        return account.getVersion();
    }

}
