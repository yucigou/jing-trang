package com.thaiopensource.relaxng.pattern;

import com.thaiopensource.xml.util.Name;

class StartTagOpenRecoverDerivFunction extends StartTagOpenDerivFunction {
  StartTagOpenRecoverDerivFunction(Name name, ValidatorPatternBuilder builder) {
    super(name, builder);
  }

  public Pattern caseGroup(GroupPattern p) {
    Pattern tem = super.caseGroup(p);
    if (p.getOperand1().isNullable())
      return tem;
    return getPatternBuilder().makeChoice(tem, memoApply(p.getOperand2()));
  }

  PatternMemo apply(PatternMemo memo) {
    return memo.startTagOpenRecoverDeriv(this);
  }
}
