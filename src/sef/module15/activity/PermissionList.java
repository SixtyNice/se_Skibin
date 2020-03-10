package sef.module15.activity;

import java.util.HashSet;
import java.util.Set;

public class PermissionList implements Permissable {

	private Set<Permission> permissions;
	private String permissionID;

	public PermissionList(String permissionID) {
		this.permissions = new HashSet<>();
		this.permissionID = permissionID;
	}

	@Override
	public void setPermission(Permission... permissions) {
		if (permissions != null) {
			for (Permission permission : permissions) {
				this.permissions.add(permission);
			}
		}
	}

	@Override
	public void removePermission(Permission... permissions) {
		if (permissions != null) {
			for (Permission permission : permissions){
				this.permissions.remove(permission);
			}
		}
	}

	@Override
	public Set<Permission> getPermission() {
		return this.permissions;
	}


	@Override
	public boolean isPermissable(Permission permission) {
		for (Permission permissionList : this.permissions) {
			if (permissionList.equals(permission)) {
				return true;
			}
		}
		return false;
	}
}
