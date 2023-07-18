package cote.toss;

// 테케 하나 탈락
public class toss1 {

  public static void main(String[] args) {
    long orderAmount = 120;
    long taxFreeAmount = 20;
    long serviceFee = 0;
    System.out.println(solution(orderAmount, taxFreeAmount, serviceFee)); // 10
  }

  /*
    주문금액(orderAmount) / 비과세금액(taxFreeAmount) / 봉사료(serviceFee)에 따른
    부가가치세 금액(answer)을 반환합니다.
  */
  private static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
    // orderAmount : 주문금액
    // taxFreeAmount : 비과세금액
    // serviceFee : 봉사료

    long supplyDae = orderAmount - serviceFee; // 공급대가(주문금액)
    System.out.println("supplyDae = " + supplyDae);

    double supplyGa = supplyDae / 1.1d; // 공급가액
    System.out.println("supplyGa = " + supplyGa);

    double taxAmount = supplyGa - taxFreeAmount; // 과세금액
    System.out.println("taxAmount = " + taxAmount);

    double answer = taxAmount * 0.1; // 부가가치세
    System.out.println("answer = " + answer);


    return supplyDae - taxFreeAmount == 1 ? 0 : (long) Math.ceil(answer);
  }
}
