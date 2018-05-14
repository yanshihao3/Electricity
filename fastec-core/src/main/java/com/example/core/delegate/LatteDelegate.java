package com.example.core.delegate;

/**
 * - @Author:  $user$
 * - @Time:  $date$ $time$
 */
public abstract class LatteDelegate extends PermissionCheckerDelegate {

    @SuppressWarnings("unchecked")
    public <T extends LatteDelegate> T getParentDelegate() {
        return (T) getParentFragment();
    }
}
