from pydoc import doc
from xml.dom.minidom import Document


def main():
    # 昇順にソートされた配列
    sorted_array = [1, 2, 3, 5, 12, 7890, 12345]
    # 探索対象の番号
    target_number = 7890
    # 探索実行
    target_index = serch_index(sorted_array, target_number)
    # 結果出力
    print(target_index)


def serch_index(sorted_array, target_number):

    # ここから記述

    listsize = len(sorted_array)  # 配列の長さ
    mid_index = int((listsize-1)/2)  # 配列中央のindex
    right_index = listsize  # 境界のindex
    left_index = 0  # 境界のindex

    while 1:

        mid = sorted_array[mid_index]

        # 中央の値よりも小さければ、右側の境界と中央のindexを更新
        if mid > target_number:

            right_index = mid_index
            mid_index = int((mid_index - left_index)/2) + left_index

        # 中央の値よりも大いきれば、左側の境界と中央のindexを更新
        if mid < target_number:
            left_index = mid_index
            mid_index += int((right_index - mid_index)/2)

        # 値が見つかった場合は変換する
        if mid == target_number:
            return mid_index

    # ここまで記述

    # 探索対象が存在しない場合、-1を返却
    return -1


if __name__ == '__main__':
    main()
