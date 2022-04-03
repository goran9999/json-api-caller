package rs.ac.bg.fon.np.json_api_caller;

import java.util.Date;
import java.util.Objects;

public class Currency {

	private String asset_id;
	private String name;
	private boolean type_is_crypto;
	private Date data_start;
	private double price_usd;
	private double volume_1mth_used;

	public Currency() {
		super();
	}

	public Currency(String asset_id, String name, boolean type_is_crypto, Date data_start, double price_usd,double volume_1mth_used) {
		super();
		this.asset_id = asset_id;
		this.name = name;
		this.type_is_crypto = type_is_crypto;
		this.data_start = data_start;
		this.price_usd = price_usd;
		this.volume_1mth_used=volume_1mth_used;
	}

	public String getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(String asset_id) {
		this.asset_id = asset_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isType_is_crypto() {
		return type_is_crypto;
	}

	public void setType_is_crypto(boolean type_is_crypto) {
		this.type_is_crypto = type_is_crypto;
	}

	public Date getData_start() {
		return data_start;
	}

	public void setData_start(Date data_start) {
		this.data_start = data_start;
	}

	public double getPrice_usd() {
		return price_usd;
	}

	public void setPrice_usd(double price_usd) {
		this.price_usd = price_usd;
	}
	
	public double getVolume_1mth_used() {
		return volume_1mth_used;
	}
	
	public void setVolume_1mth_used(double volume_1mth_used) {
		this.volume_1mth_used = volume_1mth_used;
	}

	@Override
	public String toString() {
		return "Currency [asset_id=" + asset_id + ", name=" + name + ", type_is_crypto=" + type_is_crypto
				+ ", data_start=" + data_start + ", price_usd=" + price_usd + ", volume_1mth_used=" + volume_1mth_used
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(asset_id, data_start, name, price_usd, type_is_crypto, volume_1mth_used);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		return Objects.equals(asset_id, other.asset_id) && Objects.equals(data_start, other.data_start)
				&& Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price_usd) == Double.doubleToLongBits(other.price_usd)
				&& type_is_crypto == other.type_is_crypto
				&& Double.doubleToLongBits(volume_1mth_used) == Double.doubleToLongBits(other.volume_1mth_used);
	}

	

}
