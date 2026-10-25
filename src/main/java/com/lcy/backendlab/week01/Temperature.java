package com.lcy.backendlab.week01;

/**
 * 第一周练习：完成温度换算和输出。
 *
 * <p>规则：</p>
 * <ol>
 *     <li>输入整数摄氏度，输出对应华氏度。</li>
 *     <li>换算公式：F = C * 9 / 5 + 32。</li>
 *     <li>表格每行格式必须为：{@code 0C = 32F}，最后带一个换行。</li>
 * </ol>
 */
public final class Temperature {

    private Temperature() {
    }

    /**
     * 将摄氏度转换为华氏度。
     *
     * @param celsius 摄氏度
     * @return 华氏度
     */
    public static double toFahrenheit(int celsius) {
        return celsius * 9.0 / 5 + 32;
    }

    /**
     * 生成从 start 到 end（包含两端）的温度表格。
     *
     * <p>例如 start=0、end=2 时，输出三行：
     * {@code 0C = 32F\n1C = 34F\n2C = 36F\n}。</p>
     *
     * <p>华氏度按四舍五入显示为整数。</p>
     *
     * @param start 起始摄氏度
     * @param end   结束摄氏度
     * @return 从 start 到 end（包含两端）的温度表格
     */
    public static String table(int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int c = start; c <= end; c++) {
            int fahrenheit = (int) Math.round(toFahrenheit(c));
            result.append(c)
                    .append("C = ")
                    .append(fahrenheit)
                    .append("F\n");
        }
        return result.toString();
    }
}
