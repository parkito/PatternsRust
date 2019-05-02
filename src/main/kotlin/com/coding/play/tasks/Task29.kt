import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val treeSize = scanner.next().toInt()
    val tree = ArrayList<String>()
    for (i in 1..treeSize) {
        tree.add(scanner.next())
    }
    print(treeHeight(tree))
}

fun treeHeight(tree: List<String>): Int {
    val map = HashMap<String, MutableList<String>>()

    for (i in 0 until tree.size) {
        map.computeIfAbsent(tree[i]) { mutableListOf() } += i.toString()
    }

    return height(map, tree.indexOf("-1").toString())
}

fun height(tree: Map<String, List<String>>, child: String): Int {
    if (tree[child] == null) {
        return 1
    }

    return 1 + (tree.getValue(child).map { height(tree, it) }
            .max() ?: 1)
}