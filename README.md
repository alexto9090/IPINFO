# IPINFO
Get Network provider info.



# Simply add to your projects using to your project level gradle. 

allprojects {
    repositories { 
			maven { url 'https://jitpack.io' }
		}
	}

# and below one in your app level gradle.

 Tag = 1.0 ( which release version of github project )

 dependencies {  
			implementation 'com.github.alexto9090:IPINFO:Tag'
}

