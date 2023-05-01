package com.solvdLaba.airport;

public interface Security {
    boolean isTSAPreChecked = false;

    void skipSecurityCheckLine(boolean isTSAPreChecked);//if true skip the checking line
}
