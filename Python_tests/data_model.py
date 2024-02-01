from django.contrib.admin.widgets import FilteredSelectMultiple
from django import forms

def func(num1,num2,model,field):
    class formClass(forms.ModelForm):
        vars()[field] = forms.ModelMultipleChoiceField(
            query=model.objects.all(),
            label=(num1),
            widget=FilteredSelectMultiple(
                (num2),
                False,
            ),
        )

    return fromClass
