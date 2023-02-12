package cine;
public class Paiement{
	private int montant;
	private String TransactionId;
	public Paiement(int montant,String TransactionId) {
		this.montant=montant;
		this.TransactionId=TransactionId;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public String getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
}