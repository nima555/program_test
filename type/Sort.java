import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 配列の参照による値の変更を行いたかったため、
 * 指定を無視することになりますが、配列の形式をArrayListにしてアルゴリズムを組み立てました。
 * そのため範囲外のプログラム変更を行っておりますが、御了承ください。
 * 都度コメントアウトにて示しています。
 * また、いかに問題の誤植と思しき部分について明記させていただきました。
 * 大変申し訳ありませんが、ご確認の程お願いできればと思います。
 */

class Main {

  public static void main(String[] args) {
    // ランダムに並べられた重複のない整数の配列
    ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5, 4, 6, 2, 1, 9, 8, 3, 7, 10)); // <---------型をArrayList<>に変換
    // ソート実行
    new Main().sort(array); // <----------------------------------------------------------------------------戻り値なし
    // 結果出力
    System.out.println(array.toString()); // <------------------------------------------------------------出力方法変更
  }

  private void sort(List<Integer> list) { // <------------------------------------------------------------型をArrayList<>に変換

    // 要素が一つの場合はソートの必要がないので、そのまま返却
    if (list.size() == 1) { // <-------if (array.length == 1) {
      return;
    }

    // 配列の先頭を基準値とする
    var pivot = list.get(0); // <---------var pivot = array[0];

    // ここから記述

    // 右、左側で見つかった値を保持する変数の定義
    int right = -1;
    int left = -1;

    // 右、左側から探索する index 変数の定義
    int x, y;
    x = 0;
    y = list.size() - 1;

    // 索敵開始
    while (x < y) {

      // 左側から探して、pivot以上の値が出た場合は left に保持
      if (pivot <= list.get(x)) {

        left = list.get(x);

        // 右側でも値が保持されていた場合、交換する
        if (right != -1) {
          list.set(x, right);
          list.set(y, left);

          // 保持していた値を初期化
          right = -1;
          left = -1;

        }

      }

      // 右側から探して、pivot未満の値が出た場合は right に保持
      if (pivot > list.get(y)) {

        right = list.get(y);

        // 左側でも値が保持されていた場合、交換する
        if (left != -1) {
          list.set(x, right);
          list.set(y, left);

          // 保持していた値を初期化
          right = -1;
          left = -1;

        }

      }

      // 値が保持されていない場合、index を次の位置へ移動
      if (right == -1) {

        y -= 1;

      }

      if (left == -1) {

        x += 1;

      }

    }

    // 配列の分割位置
    int middle;

    // pivot 以下の領域まで検索

    /**
     * 問題では、pivot 未満と pivot 以上の領域の分割で
     * 指定されていたが、この場合それは不適切であると思われます。
     * 例えば｛1, 3, 2｝の配列をソートしたい場合、pivot = 1 であり
     * どの値とも交換されませんが、分割した後も｛1, 3, 2｝となり
     * 永久 loop となります。正しくは、{1} と {3, 2} に分割し、
     * {3, 2}に対してソートを行うことなので、今回は指定とは異なりますが、
     * アルゴリズムを成立させるため pivot 以下と pivot より大きい領域で
     * 分割させていただきました。
     */

    for (middle = 0; middle < list.size(); middle++) {
      if (list.get(middle) > pivot)
        break;
    }

    // 配列の大きさが０出なければ、再帰関数に渡す
    if (middle != 0) {
      new Main().sort(list.subList(0, middle));
    }

    if (middle != list.size()) {
      new Main().sort(list.subList(middle, list.size()));
    }

    // ここまで記述

  }
}