package com.lcy.backendlab.week01;

/**
 * 从命令行接收起止温度，并输出温度表格。
 */
public final class CelsiusTable {

    private CelsiusTable() {
    }

    /**
     * 将命令行参数解析为起止温度。
     *
     * <p>规则：</p>
     * <ul>
     *     <li>必须正好传入两个参数。</li>
     *     <li>两个参数都必须是整数。</li>
     *     <li>起始温度不能大于结束温度。</li>
     * </ul>
     *
     * @param args 命令行参数
     * @return 长度为 2 的数组，依次保存起始温度和结束温度
     */
    public static int[] parseRange(String[] args) {
        if (args == null || args.length != 2) {
            throw new IllegalArgumentException("必须提供两个参数");
        }

        int start;
        int end;
        try {
            start = Integer.parseInt(args[0]);
            end = Integer.parseInt(args[1]);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("温度必须是整数", exception);
        }

        if (start > end) {
            throw new IllegalArgumentException("起始温度不能大于结束温度");
        }

        return new int[]{start, end};
    }

    public static void main(String[] args) {
        try {
            int[] range = parseRange(args);
            System.out.print(Temperature.table(range[0], range[1]));
        } catch (IllegalArgumentException exception) {
            System.err.println("参数错误：" + exception.getMessage());
            System.err.println("用法：java CelsiusTable <起始温度> <结束温度>");
        }
    }
}
