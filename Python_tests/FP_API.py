from django.conf import settings
from django.contrib import admin
from django.urls import include, path

urlpatterns = [
    path('path1/', admin.site.urls),
    path("path2/", include("namespace1.urls", namespace="namespace1")),
    path("path3/", include("namespace2.urls", namespace="namespace2")),
    path(f"path4/{settings.CHECK_SECRET_TOKEN}/", include("blabla.urls")),
]
