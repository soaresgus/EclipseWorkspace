package me.ninjay.mineriocustom.utils;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;


@StorageAttributes(inline=true)
public class MaterialDataStorable implements Storable {

	@Override
	public Object newInstance() {

		return null;
	}
	@SuppressWarnings("deprecation")
	@Override
	public Object store(Object object) {
		if (object instanceof MaterialData) {
			MaterialData materialData = (MaterialData) object;
			return materialData.getItemType() + ":" + materialData.getData();

		}
		return null;
	}



}
