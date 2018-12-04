package calypsox.buggy.uti;

import java.security.Permission;

/**
 * Its prevent finishing the virtual machine when a class call to System.exit()
 */
public class AvoidSystemExitSecurityManager extends SecurityManager {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.SecurityManager#checkPermission(java.security.Permission)
	 */
	@Override
	public void checkPermission(final Permission perm) {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.SecurityManager#checkPermission(java.security.Permission,
	 * java.lang.Object)
	 */
	@Override
	public void checkPermission(final Permission perm, final Object context) {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.SecurityManager#checkExit(int)
	 */
	@Override
	public void checkExit(final int status) {
		throw new SecurityException();
	}
}
