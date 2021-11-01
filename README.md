# Getting started with Jetpack Compose – Theming. (Part 1)
> ###  by <span style="color:blue">[Truong Pham](https://twitter.com/truongpham_se)</span>.
</br>

Using Theme in the XML way of Android is baffling for me to get it right. However, it’s a very important aspect of developing a professional app, to make some of the attributes (e.g. Color) easier managed, especially right now with DarkMode and LightMode support.

Fortunate, with Jetpack Compose, these have been made easier managed and understandable. It’s all code now!

</br>


🌻 Theming in compose
------------

Jetpack Compose implements Material Theming and supports a  dark theme by default. You can customize color, typography, and shape theming values to fit your product’s brand, and get access to convenient functions for working with a system of dark themes (like **isSystemInDarkTheme**, **lightColors**, and **darkColors**).

For more information, please [read the documentation](https://developer.android.com/jetpack/compose)

In Jetpack Compose, The default MaterialTheme from the documentation looks like this:

```
MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
)
```

We just need to wrap it around the MaterialTheme, and our composable functions within can leverage the attributes within. 

We can set custom attributes:

* **colors:** A complete definition of the Material Color theme for this hierarchy.
* **typography:** A set of text styles to be used as this hierarchy’s typography system.
* **shapes:** A set of shapes to be used by the components in this hierarchy.

So what role do these attributes play in the jetpack compose theme and how are they used?

Let’s look into each of it.

</br>


🔫 Elements in the jetpack compose theme
-----------
-----------

</br>

### 🧬 Colors

</br>

The firstly, Jetpack Compose uses the Color class from Compose’s graphics package. We have many ways to define a color, but there are two common ways we use it more frequently.

One Way is defining the hex code of the color

```
val Purple200 = Color(0xFFBB86FC)
```

The other way is specifying the RGB values to the Color class:
```
val red = Color(red = 255f, green = 0f, blue = 0f)
```

Since ARGB Hex is just a bunch of jargon to describe what the heck “0XFF00bc00” means, let me translate:

* First two characters **0x** tell the compiler that this is a hexadecimal number.
* Second two characters , *“FF”* or *“DC“*, represent Transparency/Opaqueness/**Alpha** in Hex.
* The remaining six character pairs represent Red, Green, and Blue (RGB color).

The secondly, Create a file called something like Color.kt (the name does not matter) and fill it with immutable values:

[Color.kt](https://github.com/truongpham1007/ThemingInCompose/blob/main/Themming/app/src/main/java/com/example/themming/ui/theme/Color.kt)

```

package com.example.themming.ui.theme

import androidx.compose.ui.graphics.Color


val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val yellow200 = Color(0xffffeb46)
val yellow400 = Color(0xffffc000)
val yellow500 = Color(0xffffde03)
val yellowDarkPrimary = Color(0xff242316)
val yellowLightPrimary = Color(0xffd4d3f6)

val blue200 = Color(0xff91a4fc)
val blue700 = Color(0xff0336ff)
val blue800 = Color(0xff0035c9)
val blueDarkPrimary = Color(0xff1c1d24)
val blueLightPrimary = Color(0xffecedd4)

val pink200 = Color(0xffff7597)
val pink500 = Color(0xffff0266)
val pink600 = Color(0xffd8004d)
val pinkDarkPrimary = Color(0xff24191c)
val pinkLightPrimary = Color(0xffecedd4)

```

The finally, Colors class allow us to define different 
[Material Design Color System](https://material.io/design/color/the-color-system.html)

```
class Colors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    surface: Color,
    error: Color,
    onPrimary: Color,
    onSecondary: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    isLight: Boolean
)
```

![alt](https://i2.wp.com/howtodoandroid.com/wp-content/uploads/2021/09/colors.png?w=1064&ssl=1)


There are around 13 attributes in the constructor of Colors. Let’s see what each attribute means.

* Primary  – color displayed most frequently across your app’s screens and components;
* Primary Variant – color is used to distinguish elements using primary colors, such as top app bar and the system bar.
* Secondary – color provides more ways to accent and distinguish your product. Having a secondary color is optional, and should be applied sparingly to accent select parts of your UI;
* SecondaryVariant – color is used to distinguish elements using secondary colours;
* Background – color appears behind scrollable content;
* **Surface** – color uses on surfaces of components, like cards and menus;
* **Error** – color used for indicating an error.
* **OnPrimary** – color of text and icons displayed on top of the primary color.
* **OnSecondary** – color of text and icons displayed on top of the secondary color;
* **OnBackground** – color of text and icons displayed on top of the background color;
* **OnSurface** – color of text and icons displayed on top of the surface color;
* **OnError** – color of text and icons displayed on top of the error color.
* **IsLight** – Whether these colors are considered as a “light” or “dark” set of colors.


To make our support for DarkMode and LightMode easier, Jetpack Compose also provides two functions that generates default colors for these modes.

* darkColors
* lightColors

[Theme.kt](https://github.com/truongpham1007/ThemingInCompose/blob/main/Themming/app/src/main/java/com/example/themming/ui/theme/Theme.kt)

```
private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)
```

```
private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200
)
```
</br>

### 🔡 Typography

</br>

This is to define the typography theme for the design, as per [the material document](https://material.io/develop/android/theming/typography).

The Typograph is a class that helps us to style the texts. With the help of the Typograph class, we can customize FontFamily, FontStyle, FontWeight, LetterSpacing, TextDecoration, Color, and many more attributes related to texts.

```
class Typography(
    defaultFontFamily: FontFamily = FontFamily.Default,
    h1: TextStyle,
    h2: TextStyle,
    h3: TextStyle,
    h4: TextStyle,
    h5: TextStyle,
    h6: TextStyle,
    subtitle1: TextStyle,
    subtitle2: TextStyle,
    body1: TextStyle,
    body2: TextStyle,
    button: TextStyle,
    caption: TextStyle,
    overline: TextStyle
)
```


![alt](https://i0.wp.com/howtodoandroid.com/wp-content/uploads/2021/09/typography.png?w=1064&ssl=1)

In addition to this, we should configure a Typography object with the following parameters:

* **h1** is the largest headline, reserved for short and important text.
* **h2** is the second-largest headline, reserved for short and important text.
* **h3** is the third-largest headline, reserved for short and important text.
* **h4** is the fourth-largest headline, reserved for short and important text.
* **h5** is the fifth-largest headline, reserved for short and important text.
* **h6** is the sixth-largest headline, reserved for short and important text.
* **subtitle1** is the largest subtitle and is typically reserved for medium-emphasis text that is shorter in length.
* **subtitle2** is the smallest subtitle and is typically reserved for medium-emphasis text that is shorter in length.
* **body1** is the largest body and is typically reserved for a long-form text that is shorter in length.
* **body2** is the smallest body and is typically reserved for a long-form text that is shorter in length.
* **button** is reserved for a button text.
* **caption** is one of the smallest font sizes it reserved for annotating imagery or introduce a headline.
* **overline** is one of the smallest font sizes.

We can override the needed font Style like h1, body1, button, etc as below,

[Type.kt](https://github.com/truongpham1007/ThemingInCompose/blob/main/Themming/app/src/main/java/com/example/themming/ui/theme/Type.kt)

```
// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
```
</br>

### 🔶  Shapes

</br>


Besides Color and Typography, we can also provide Shapes, as per the Material Documentation. Here, in specific, we are defining the round corner radius of 3 types of shapes, small, medium, and large.

[Shape.kt](https://github.com/truongpham1007/ThemingInCompose/blob/main/Themming/app/src/main/java/com/example/themming/ui/theme/Shape.kt)

```
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)
```

For more information, please read [the documentation](https://material.io/blog/design-material-theme-shape)

</br>


🔫 Create a Material Theme
-----------
-----------

</br>

### ✴️   Customize the Theme

By using the instances of colors, typography, and shapes above, we can make a material theme that can be used across the application.

```
@Composable
fun JetpackComposeThemingTheme(
    colors: Colors,
    content: @Composable() () -> Unit
) {
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
```

CustomComposeTheme is a composable function with two attributes:

**isDarkTheme** — To set the dark or light color scheme based on checking isSystemInDarkTheme.
**content** — A composable function where the MaterialTheme is to be used.

```
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Column {
                    Text(text = "Hello world!!!")
                }
            }
        }

    }
}
```

### ⚫ Dark theme

Material composable that make use of a Surface (like Card, TopAppBar, etc.) automatically include dark theme properties like desaturated colors for accessibility, elevation overlays, and limited color accents. You can also incorporate these in custom scenarios.

isSystemInDarkTheme() is a call that asks any compatible Android device for the user’s preference of a light or dark theme.

It returns a boolean value which we can use in a Ternary (Conditional) Assignment expression such as

```
colors = if (darkTheme) DarkColorPalette else LightColorPalette.
```

code to add the dark mode in theme,

[Theme.kt](https://github.com/truongpham1007/ThemingInCompose/blob/main/Themming/app/src/main/java/com/example/themming/ui/theme/Theme.kt)

```
@Composable
fun ThemmingTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
```

</br>

# In Conclusion

Based on the sharing above, below is a diagram that connects up all the discussed code together.

![alt](https://miro.medium.com/max/1400/1*lQULtzpG1sRuoQj0_R7m1w.png)

Hope this provides a high-level view of how we can define our own custom theme as well as dynamically change it.

