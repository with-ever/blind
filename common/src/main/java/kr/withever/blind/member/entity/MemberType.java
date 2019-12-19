package kr.withever.blind.member.entity;

public enum MemberType {
  NORMAL("N"), COMPANY("C");

  private String code;

  MemberType(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
