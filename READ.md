通常遍历字符串时，先将字符串转换为字符数组

s:字符串

Array:字符数组

char[] Array = s.toCharArray();

注意：

character 与 char 不是一个东西

char是一种原始类型 

character 是一个包装类 character 类型的对象
包含一个类型为char的字段.此外,该类提供了几种方法来确定字符的类别(小写字母,数字等)以及将字符从大写转换为小写

StringBuilder:

字符串缓冲区，底层是一个没有被final修饰的数组，可以改变长度，可以提高字符串的操作效率

            //String转换为StringBuilder
            StringBuilder builder = StringBuilder(str1);

			//向StringBuilder中添加字符串
			builder.append("World!");

			//StringBuilder转换为String
			String str2 = builder.toString();
